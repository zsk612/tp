package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PastWorkoutSessionRecord implements Comparable<PastWorkoutSessionRecord> {

    private final String filePath;
    private final LocalDateTime creationTime;
    private LocalDateTime lastEditTime;
    private final ArrayList<String> tags;

    /**
     * Constructer of a new PastWorkoutSessionRecord.
     * @param filePath File path of where the records of the session are stored
     * @param tags Tags attached to this session
     */
    public PastWorkoutSessionRecord(String filePath, ArrayList<String> tags) {
        this.filePath = filePath;
        creationTime = LocalDateTime.now();
        lastEditTime = LocalDateTime.now();
        this.tags = tags;
    }

    public PastWorkoutSessionRecord(String filePath, LocalDateTime creationTime,
                                    LocalDateTime lastEditTime, ArrayList<String> tags) {
        this.filePath = filePath;
        this.creationTime = creationTime;
        this.lastEditTime = lastEditTime;
        this.tags = tags;
    }

    /**
     * Check if this record contains all the given tag.
     * @param tgs list of tags specified
     * @return True if all contained; otherwise false
     */
    public boolean containsAll(ArrayList<String> tgs) {
        return tags.containsAll(tgs);
    }

    /**
     * Check if this record is created on a given date.
     * @param date list of tags specified
     * @return True if it is created on that day; otherwise false
     */
    public boolean isCreatedOn(LocalDate date) {
        return date.equals(creationTime.toLocalDate());
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return String.format("%-15s %s", creationTime.toLocalDate(), tags.toString());
    }

    @Override
    public int compareTo(PastWorkoutSessionRecord o) {
        if (creationTime.isBefore(o.creationTime)) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PastWorkoutSessionRecord)) {
            return false;
        }
        return creationTime.equals(((PastWorkoutSessionRecord) o).creationTime)
                && lastEditTime.equals(((PastWorkoutSessionRecord) o).lastEditTime)
                && tags.equals(((PastWorkoutSessionRecord) o).tags);
    }

    /**
     * Update last edited time when edited.
     * @return a new PastWorkoutSessionRecord with updated lastEdit time
     */
    public PastWorkoutSessionRecord edit() {
        return new PastWorkoutSessionRecord(filePath, creationTime, LocalDateTime.now(), this.tags);
    }
}
