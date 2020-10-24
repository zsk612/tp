package models;

import exceptions.SchwarzeneggerException;
import exceptions.workoutmanager.SchwIoException;
import logger.SchwarzeneggerLogger;
import storage.workout.WorkOutManagerStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static ui.CommonUi.LS;
import static workout.workoutmanager.WorkoutManagerParser.parseSearchConditions;

public class PastRecordList {
    private static PastRecordList SingPastFile = null;
    private Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    private static List<PastWorkoutSessionRecord> pastFiles;
    WorkOutManagerStorage storage;


    /**
     * Singleton structure.
     * @return
     */
    public static PastRecordList getInstance() {
        if (SingPastFile == null) {
            SingPastFile = new PastRecordList();
        }
        return SingPastFile;
    }

    private PastRecordList() {
        storage = new WorkOutManagerStorage();
        storage.init();
        try {
            pastFiles = storage.readPastRecords();
            logger.log(Level.INFO, "Workout records loaded.");
        } catch (SchwIoException e) {
            pastFiles = new ArrayList<>();
            logger.log(Level.INFO, "Workout records cannot be loaded.");
            System.out.println("got bug");
        }
    }

    /**
     * Clear all the local storage file and past records.
     * @throws SchwIoException if error occured writing to file
     */
    public void clear() throws SchwIoException {
        while (pastFiles.size() != 0) {
            delete(1);
        }
        logger.log(Level.WARNING, "Record is cleared.");
    }

    /**
     * Delete a file and its past record at a given index.
     * @param index index of the file to be cleard
     * @throws SchwIoException if error occured writing to file
     */
    public void delete(int index) throws SchwIoException {
        PastWorkoutSessionRecord deletedRecord;
        deletedRecord = pastFiles.get(index - 1);
        pastFiles.remove(index - 1);
        File myFile = new File(deletedRecord.getFilePath());
        myFile.delete();
        storage.writePastRecords(pastFiles);
        logger.log(Level.INFO, "Record is deleted.");
    }

    /**
     * Search based on conditions and return a string representation of all the records.
     * that satisfies the condition
     * @param args String of user input
     * @returna string representation of all the records that satisfies the condition
     */
    public String search(String[] args) {
        ArrayList<Predicate<PastWorkoutSessionRecord>> conditions = parseSearchConditions(args);

        List<PastWorkoutSessionRecord> result = pastFiles.stream()
                .filter(conditions.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());

        int index = 1;
        String info =  pastFiles.size() + "  records are found:" + LS;
        for (PastWorkoutSessionRecord wsr : result) {
            String row = String.format("%-8s", index) + wsr.toString() + LS;
            info += row;
            index += 1;
        }
        info = info.trim();
        logger.log(Level.INFO, "Search completed.");
        return info;
    }

    /**
     * Edit a file and its past record at a given index.
     * @param index index of the file to be edited
     * @throws SchwIoException if error occurred reading or writing to file
     */
    public String edit(int index) throws SchwIoException {
        PastWorkoutSessionRecord editedRecord;
        editedRecord = pastFiles.get(index - 1);
        PastWorkoutSessionRecord newRecord = editedRecord.edit();
        pastFiles.set(index - 1, newRecord);
        storage.writePastRecords(pastFiles);
        logger.log(Level.INFO, "Edit completed.");
        return newRecord.getFilePath();
    }

    /**
     * add a new file and record.
     * @param tags tags on the new record
     * @throws SchwIoException if error occurred reading or writing to file
     */
    public String add(ArrayList<String> tags) throws SchwarzeneggerException {
        String newFilePath = storage.createfile();
        PastWorkoutSessionRecord newRecord = new PastWorkoutSessionRecord(newFilePath, tags);
        pastFiles.add(newRecord);
        storage.writePastRecords(pastFiles);
        logger.log(Level.INFO, "Add completed.");
        return  newFilePath;
    }

    /**
     * List all records.
     * @param args null
     * @throws SchwIoException if error occurred reading file
     */
    public String list(String[] args) {
        int index = 1;
        String info = "You have " + pastFiles.size() + " records:" + LS;
        for (PastWorkoutSessionRecord wsr : pastFiles) {
            String row = String.format("%-8s", index) + wsr.toString() + LS;
            info += row;
            index += 1;
        }
        info = info.trim();
        logger.log(Level.INFO, "List completed.");
        return info;
    }
}
