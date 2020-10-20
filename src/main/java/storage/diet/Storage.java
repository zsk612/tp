package storage.diet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import diet.dietsession.DietSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

/**
 * This class holds the data loaded during runtime and read and writes to the local storage.
 */
public class Storage {

    private static final String FILEPATH = "saves/diet/";
    private static Gson gson;
    private static File file = null;

    /**
     * Initialise the database with locally stored data.
     * If the local file is not found. It creates the relevant file and folder.
     *
     * @throws IOException If director or file cannot be created.
     */
    public void init(String filePath) throws IOException {
        logger.log(Level.INFO, "creating diet session save file");

        gson = new GsonBuilder().setPrettyPrinting()
                .create();

        //creates the file
        String fileName = "saves/diet/" + filePath + ".json";
        file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        file.createNewFile();

    }

    /**
     * Write the content in dietSession to a local file.
     * If the local file is not found. It creates the relevant file and folder.
     *
     * @throws IOException If director or file cannot be created.
     */
    public void writeToStorageDietSession(String filePath, DietSession dietSession) throws IOException {
        logger.log(Level.INFO, "saving file to location");
        File file = new File(FILEPATH + filePath + ".json");
        if (file.exists()) {
            file.delete();
        }
        FileWriter writer = new FileWriter(file.getPath());
        gson.toJson(dietSession, writer);
        logger.log(Level.INFO, "file saving complete");
        writer.flush();
        writer.close();
    }

    public DietSession readDietSession(String filePath) {
        Gson gson = new Gson();
        DietSession dietSession;
        dietSession = null;
        try {
            File file = new File(System.getProperty("user.dir") + "/"
                    + FILEPATH + filePath);

            Reader reader = new FileReader(file.getPath());
            dietSession = gson.fromJson(reader, DietSession.class);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("There seems to be no file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dietSession;
    }
}
