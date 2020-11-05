package logic.commands.diet.dietmanager;

import logic.commands.Command;
import diet.dietsession.DietSession;
import storage.diet.DietStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

public class DietSessionEdit extends Command {

    static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for edit command to edit diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();

        try {
            DietSession ds = null;

            assert listOfFiles != null : "List of files should not be null";
            ds = storage.readDietSession(listOfFiles[Integer.parseInt(input) - 1].getName());
            ds.start(false, Integer.parseInt(input));
            saveToFile(storage, ds);
            logger.log(Level.INFO, "Diet session in edit mode");
        } catch (NullPointerException | FileNotFoundException
                | NumberFormatException e) {
            ui.showToUser("Wrong format, please enter in the format:\n\t "
                    + "edit [INDEX_OF_SESSION]");
            logger.log(Level.WARNING, "No file found at array index");
        } catch (IOException e) {
            logger.log(Level.WARNING, "failed to execute diet session");
        } catch (IndexOutOfBoundsException e) {
            ui.showToUser("Sorry, there is no file at that index.");
        }
    }

    /**
     * Constructs method to save changes to storage file.
     *
     * @param storage storage for diet manager
     * @param ds dietSession that is being changed
     */
    private void saveToFile(DietStorage storage, DietSession ds) {
        try {
            storage.init(ds.getDate().toString() + " " + ds.getTypeInput());
            storage.writeToStorageDietSession(ds.getDate().toString() + " " + ds.getTypeInput(), ds);
            logger.log(Level.INFO, "Diet session successfully saved");
        } catch (IOException e) {
            logger.log(Level.WARNING, "save profile session failed");
            ui.showToUser("Failed to save your diet session!");
        }
    }
}
