package storage.workout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import models.Exercise;
import models.ExerciseList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * This class holds the data loaded during runtime and read and writes to the local storage.
 */
public class Storage {

    private static final String FILEPATH = "./saves/workout";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static File file = null;


    /**
     * Write the content in TaskList to a local file.
     * If the local file is not found. It creates the relevant file and folder.
     *
     * @throws IOException If director or file cannot be created.
     */
    public void writeToStorage(String filePath, ExerciseList exerciseList) throws IOException {
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file.getPath());
        gson.toJson(exerciseList.exerciseList, writer);
        writer.flush();
        writer.close();
    }

    public void readFileContents(String filePath, ExerciseList exerciseList) throws FileNotFoundException {
        File file = new File(filePath);

        Type taskListType = new TypeToken<ArrayList<Exercise>>() {
        }.getType();
        JsonReader reader = new JsonReader(new FileReader(file.getPath()));
        exerciseList.exerciseList.clear();
        try {
            exerciseList.exerciseList.addAll(gson.fromJson(reader, taskListType));
        } catch (NullPointerException e) {
            System.out.printf("");
        }
    }


}
