package commands.diet.dietmanager;

import commands.Command;
import diet.dietsession.DietSession;
import storage.diet.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionEdit extends Command {
    static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for edit command to edit diet sessions.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();

        try {
            DietSession ds = null;

            assert listOfFiles != null : "List of files should not be null";
            ds = storage.readDietSession(listOfFiles[Integer.parseInt(input) - 1].getName());
            ds.start();
            logger.log(Level.INFO, "Diet session in edit mode");
        } catch (NullPointerException | FileNotFoundException
                | IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry, there is no file at that index.");
            logger.log(Level.WARNING, "No file found at array index");
        } catch (IOException e) {
            logger.log(Level.WARNING, "failed to execute diet session");
            e.printStackTrace();
        }
    }
}
