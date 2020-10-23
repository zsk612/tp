package models;

import exceptions.SchwarzeneggerException;
import exceptions.workoutmanager.SchwIoException;
import storage.workout.WorkOutManagerStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static workout.workoutmanager.WorkoutManagerParser.parseSearchConditions;

public class PastRecordList {
    private static PastRecordList SingPastFile = null;

    private static List<PastWorkoutSessionRecord> pastFiles;
    WorkOutManagerStorage storage;


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
        } catch (SchwIoException e) {
            System.out.println("got bug");
        }
    }

    public void clear() {
        while (pastFiles.size() != 0) {
            delete(1);
        }
    }

    public void delete(int index) {
        PastWorkoutSessionRecord deletedRecord;
        deletedRecord = pastFiles.get(index - 1);
        pastFiles.remove(index - 1);
        File myFile = new File(deletedRecord.getFilePath());
        myFile.delete();
        storage.writePastRecords(pastFiles);
    }

    public String search(String[] args) {
        ArrayList<Predicate<PastWorkoutSessionRecord>> conditions = parseSearchConditions(args);

        List<PastWorkoutSessionRecord> result = pastFiles.stream()
                .filter(conditions.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());

        System.out.println(result.size() + " records found.");
        for (PastWorkoutSessionRecord wsr : result) {
            int index = pastFiles.indexOf(wsr) + 1;
            System.out.printf("%-8s", index);
            System.out.println(wsr);
        }
        return "searchTODO";
    }

    public String edit(int index) {
        PastWorkoutSessionRecord editedRecord;
        editedRecord = pastFiles.get(index - 1);
        PastWorkoutSessionRecord newRecord = editedRecord.edit();
        pastFiles.set(index - 1, newRecord);
        storage.writePastRecords(pastFiles);
        return newRecord.getFilePath();
    }

    public String add(ArrayList<String> tags) throws SchwarzeneggerException {
        String newFilePath = storage.createfile();
        PastWorkoutSessionRecord newRecord = new PastWorkoutSessionRecord(newFilePath, tags);
        pastFiles.add(newRecord);
        storage.writePastRecords(pastFiles);
        return  newFilePath;
    }

    public static String list(String[] args) {
        int index = 1;
        System.out.println("the length of list is " + pastFiles.size());
        for (PastWorkoutSessionRecord wsr : pastFiles) {
            System.out.printf("%-8s", index);
            System.out.println(wsr);
            index += 1;
        }
        return "list TODO";
    }
}
