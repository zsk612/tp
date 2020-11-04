package commands.diet.dietmanager;

import commands.Command;
import commands.CommandResult;
import storage.diet.DietStorage;

import java.io.File;
import java.util.logging.Level;

import static seedu.duke.Constant.PATH_TO_DIET_FOLDER;
import static ui.CommonUi.clearMsg;
import static ui.diet.dietmanager.DietManagerUi.DIET_DELETE_SUCCESS;

public class DietSessionDelete extends Command {

    /**
     * Overrides execute for delete command to delete diet sessions.
     *  @param input user input for command
     * @param storage storage for diet manager
     * @return
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) {
        File folder = new File(PATH_TO_DIET_FOLDER);
        File[] listOfFiles = folder.listFiles();
        String result = "";
        try {
            assert !input.isEmpty() : "No files to delete or wrong folder";
            assert listOfFiles != null;
            String fileName = listOfFiles[Integer.parseInt(input) - 1]
                    .getName().replaceFirst("[.][^.]+$", "");
            result = DIET_DELETE_SUCCESS;
            listOfFiles[Integer.parseInt(input) - 1].delete();
            logger.log(Level.INFO, "Deleted Diet Session successfully");
        } catch (NumberFormatException e) {
            result = "Wrong format, please enter in the format:\n\t delete [INDEX]";
            logger.log(Level.INFO, "No or wrong index for deletion in dietManager");
        } catch (IndexOutOfBoundsException e) {
            result = "Sorry, there is no file at that index.";
            logger.log(Level.INFO, "No input for session index");
        } catch (NullPointerException e) {
            result = "It looks like you have no sessions saved!";
        }
        return new CommandResult(result);
    }
}
