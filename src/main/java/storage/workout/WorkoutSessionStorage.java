package storage.workout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import models.Exercise;
import models.ExerciseList;
import ui.workout.workoutsession.WorkoutSessionUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

//@@author yujinyang1998
/**
 * This class holds the data loaded during runtime and read and writes to the local storage.
 */
public class WorkoutSessionStorage {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Write the content in TaskList to a local file.
     * If the local file is not found. It creates the relevant file and folder.
     *
     * @throws IOException If director or file cannot be created.
     */
    public void writeToStorage(String filePath, ExerciseList exerciseList) throws IOException {
        assert (filePath != null && exerciseList != null) : "File corrupted";
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file.getPath());
        gson.toJson(exerciseList.exerciseList, writer);
        writer.flush();
        writer.close();
    }

    public void readFileContents(String filePath, ExerciseList exerciseList) throws FileNotFoundException {
        assert (filePath != null && exerciseList != null) : "File corrupted";
        File file = new File(filePath);

        Type taskListType = new TypeToken<ArrayList<Exercise>>() {
        }.getType();
        JsonReader reader = new JsonReader(new FileReader(file.getPath()));
        exerciseList.exerciseList.clear();
        try {
            exerciseList.exerciseList.addAll(gson.fromJson(reader, taskListType));
        } catch (NullPointerException e) {
            System.out.printf("");
        } catch (JsonSyntaxException e) {
            WorkoutSessionUi.saveCorruptedError(filePath);
        }
    }


}
