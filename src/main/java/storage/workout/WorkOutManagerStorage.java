package storage.workout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import exceptions.workoutmanager.SchwIoException;
import logger.SchwarzeneggerLogger;
import models.PastWorkoutSessionRecord;
import seedu.duke.Constant;
import ui.CommonUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static ui.workout.workoutmanager.WorkoutManagerUi.LOADINGFILE;

public class WorkOutManagerStorage {

    /**
     * This list contains all the past record files' file name and some other relevant info.
     * It is saved in a file called history.json.
     * Each time it initilises, it will read history.json file and save it to this list.
     * Each time adding/removing record will update this list and write again to local storage.
     */
    private Gson gson;
    private final Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    private final CommonUi ui = new CommonUi();

    /**
     * This variable keeps track of file name.
     * It should be replaced with something else,
     * TODO:e.g. a hashcode that can identify each file distinctly.
     */
    private int recordCount = 0;

    public void init() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Read all past records.
     * @return a list of PastWorkoutSessionRecord
     * @throws SchwIoException if error in reading the file
     */
    public ArrayList<PastWorkoutSessionRecord> readPastRecords() throws SchwIoException {
        logger.info("Start loading files");
        System.out.println(LOADINGFILE);

        ArrayList<PastWorkoutSessionRecord> pastFiles;
        File file = new File(Constant.WORKOUTSESSIONHISTORY);
        Type taskListType = new TypeToken<ArrayList<PastWorkoutSessionRecord>>(){}.getType();
        try {
            JsonReader reader = new JsonReader(new FileReader(file.getPath()));
            pastFiles = gson.fromJson(reader, taskListType);
        } catch (FileNotFoundException e) {
            logger.info("File is not found.");
            createMetaFile(Constant.WORKOUTSESSIONHISTORY);
            pastFiles = new ArrayList<>();
        }
        if (pastFiles == null) {
            pastFiles = new ArrayList<>();
        }
        assert (pastFiles != null);
        recordCount = pastFiles.size();
        logger.info("Loading completed");
        return pastFiles;
    }

    /**
     * Write all past records to local storage.
     * @param pastFiles the list of records to be stored
     * @throws SchwIoException if error occurs in writing to file
     */
    public void writePastRecords(List<PastWorkoutSessionRecord> pastFiles) throws SchwIoException {
        logger.info("Saving the changes...");
        File file = new File(Constant.WORKOUTSESSIONHISTORY);
        FileWriter writer;
        try {
            writer = new FileWriter(file.getPath());
            gson.toJson(pastFiles, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.info("Error occured when saving the progress.");
            throw new SchwIoException("Error occured when saving the progress...");
        }
        logger.info("All changes saved.");
        recordCount = pastFiles.size();
    }

    private void createMetaFile(String path) throws SchwIoException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            logger.info("File cannot be created at " + path + ".");
            throw new SchwIoException("The local storage file cannot be created at " + path);
        }
    }

    /**
     * Create a new file to store a new workout session data.
     * @return file path of new created file
     * @throws SchwIoException if error occurs in creating the file
     */
    public String createfile() throws SchwIoException {
        String newFilePath = Constant.WORKOUTSESSIONFOLDER + recordCount + ".json";
        File file = new File(newFilePath);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
            return newFilePath;
        } catch (IOException e) {
            logger.info("File is not created at " + newFilePath + ".");
            throw new SchwIoException("The local storage file cannot be created at " + newFilePath);
        }
    }
}
