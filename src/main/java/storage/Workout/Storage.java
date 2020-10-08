package storage.Workout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import workout.workoutsession.exercise.Exercise;


import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * This class holds the data loaded during runtime and read and writes to the local storage.
 */
public class Storage {

    private static final String FILEPATH = "./saves/workout";
    private static ArrayList<Exercise> taskList = new ArrayList<>();
    private static Gson gson;

    /**
     * Initialise the database with locally stored data.
     * If the local file is not found. It creates the relevant file and folder.
     * @throws IOException If director or file cannot be created.
     */
    public static void initialise() throws IOException {
        System.out.println("Trying to load user data...");

        /*RuntimeTypeAdapterFactory<Task> taskAdapterFactory = RuntimeTypeAdapterFactory
                .of(Task.class, "type", true)
                .registerSubtype(ToDo.class, "Todo")
                .registerSubtype(Deadline.class, "Deadline")
                .registerSubtype(Event.class, "Event");*/

        gson = new GsonBuilder().setPrettyPrinting()
                .create();

        try {
            readFileContents();
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found");
            fileNotFoundHandler();
        }
        System.out.println("Loading completed.");
    }

    /**
     * Write the content in TaskList to a local file.
     * If the local file is not found. It creates the relevant file and folder.
     * @throws IOException If director or file cannot be created.
     */
    public static void writeToStorage() throws IOException {
        FileWriter writer;
        try {
            writer = new FileWriter(FILEPATH);
        } catch (IOException e) {
            fileNotFoundHandler();
            writer = new FileWriter(FILEPATH);
        }
        gson.toJson(taskList, writer);
        writer.flush();
        writer.close();
    }

    private static void readFileContents() throws FileNotFoundException {
        Type taskListType = new TypeToken<ArrayList<Exercise>>(){}.getType();

        JsonReader reader = new JsonReader(new FileReader(FILEPATH));

        taskList = gson.fromJson(reader, taskListType);
    }

    private static void fileNotFoundHandler() throws IOException {
        String fileName = "saves/workout/" + Integer.toString(1);
        File dir = new File("saves/workout/");
        dir.mkdir();
        File yourFile = new File(FILEPATH);
        yourFile.createNewFile();
    }
}
