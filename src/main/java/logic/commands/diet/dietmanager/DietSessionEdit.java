package logic.commands.diet.dietmanager;

import logic.commands.Command;
import diet.dietsession.DietSession;
import logic.commands.CommandResult;
import storage.diet.DietStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import static seedu.duke.Constant.PATH_TO_DIET_FOLDER;
import static ui.diet.dietmanager.DietManagerUi.*;

public class DietSessionEdit extends Command {
    /**
     * Overrides execute for edit command to edit diet sessions.
     *  @param input user input for command
     * @param storage storage for diet manager
     * @return CommandResult instance to print command message
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
            logger.log(Level.INFO, "Diet session in edit mode");
            result = DIET_NEW_SUCCESS;
        } catch (NullPointerException | FileNotFoundException
                | NumberFormatException e) {
            result = DIET_EDIT_WRONG_FORMAT;
            logger.log(Level.WARNING, "No file found at array index");
        } catch (IOException e) {
            logger.log(Level.WARNING, "failed to execute diet session");
        } catch (IndexOutOfBoundsException e) {
            result = DIET_FILE_ARRAY_OUT_OF_BOUND;
        }
        return new CommandResult(result);
    }
}
