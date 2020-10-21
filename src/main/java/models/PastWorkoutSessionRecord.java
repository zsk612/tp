package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PastWorkoutSessionRecord implements Comparable<PastWorkoutSessionRecord> {

    private final String filePath;
    private final LocalDateTime creationTime;
    private LocalDateTime lastEditTime;
    private final ArrayList<String> tags;

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

    public boolean containsAll(ArrayList<String> tgs) {
        return tags.containsAll(tgs);
    }

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

    public PastWorkoutSessionRecord edit() {
        return new PastWorkoutSessionRecord(filePath, creationTime, LocalDateTime.now(), this.tags);
    }
}
