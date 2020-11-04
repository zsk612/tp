package commands.diet.dietmanager;

import commands.Command;
import commands.CommandResult;
import diet.dietsession.DietSession;
import storage.diet.DietStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import static seedu.duke.Constant.PATH_TO_DIET_FOLDER;
import static ui.diet.dietmanager.DietManagerUi.DIET_NEW_SUCCESS;

public class DietSessionEdit extends Command {
    /**
     * Overrides execute for edit command to edit diet sessions.
     *  @param input user input for command
     * @param storage storage for diet manager
     * @return
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) {
        String result = "";
        File folder = new File(PATH_TO_DIET_FOLDER);
        File[] listOfFiles = folder.listFiles();

        try {
            DietSession ds = null;

            assert listOfFiles != null : "List of files should not be null";
            ds = storage.readDietSession(listOfFiles[Integer.parseInt(input) - 1].getName());
            ds.start(false, Integer.parseInt(input));
            saveToFile(storage, ds);
            logger.log(Level.INFO, "Diet session in edit mode");
            result = DIET_NEW_SUCCESS;
        } catch (NullPointerException | FileNotFoundException
                | NumberFormatException e) {
            result = "Wrong format, please enter in the format:\n\t "
                    + "edit [INDEX_OF_SESSION]";
            logger.log(Level.WARNING, "No file found at array index");
        } catch (IOException e) {
            logger.log(Level.WARNING, "failed to execute diet session");
        } catch (IndexOutOfBoundsException e) {
            result = "Sorry, there is no file at that index.";
        }
        return new CommandResult(result);
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
