package storage.workout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import exceptions.workoutmanager.SchwIoException;
import models.PastWorkoutSessionRecord;
import seedu.duke.Constant;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WorkOutManagerStorage {

    /**
     * This list contains all the past record files' file name and some other relevant info.
     * It is saved in a file called history.json.
     * Each time it initilises, it will read history.json file and save it to this list.
     * Each time adding/removing record will update this list and write again to local storage.
     */
    private Gson gson;

    /**
     * This variable keeps track of file name.
     * It should be replaced with something else,
     * TODO:e.g. a hashcode that can identify each file distinctly.
     */
    private int recordCount = 0;

    public void init() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public ArrayList<PastWorkoutSessionRecord> readPastRecords() throws SchwIoException {
        ArrayList<PastWorkoutSessionRecord> pastFiles;
        File file = new File(Constant.WORKOUTSESSIONHISTORY);
        WorkoutManagerUi.printStartLoading();
        Type taskListType = new TypeToken<ArrayList<PastWorkoutSessionRecord>>(){}.getType();
        try {
            JsonReader reader = new JsonReader(new FileReader(file.getPath()));
            pastFiles = gson.fromJson(reader, taskListType);
        } catch (FileNotFoundException e) {
            createMetaFile(Constant.WORKOUTSESSIONHISTORY);
            pastFiles = new ArrayList<>();
        }
        recordCount = pastFiles.size();
        return pastFiles;
    }

    public void writePastRecords(List<PastWorkoutSessionRecord> pastFiles) {
        File file = new File(Constant.WORKOUTSESSIONHISTORY);
        FileWriter writer;
        try {
            writer = new FileWriter(file.getPath());
            gson.toJson(pastFiles, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occured when saving the progress...");
        }
        recordCount = pastFiles.size();
    }

    public String createMetaFile(String path) throws SchwIoException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
            return path;
        } catch (IOException e) {
            throw new SchwIoException("The local storage file cannot be created at " + path);
        }
    }

    public String createfile() throws SchwIoException {
        String newFilePath = Constant.WORKOUTSESSIONFOLDER + recordCount + ".json";
        File file = new File(newFilePath);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
            return newFilePath;
        } catch (IOException e) {
            throw new SchwIoException("The local storage file cannot be created at " + newFilePath);
        }
    }
}
