package commands.diet.dietmanager;

import commands.Command;
import storage.diet.DietStorage;

import java.io.File;
import java.util.logging.Level;

public class DietSessionDelete extends Command {

    static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for delete command to delete diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        try {
            assert !input.isEmpty() : "No files to delete or wrong folder";
            assert listOfFiles != null;
            String fileName = listOfFiles[Integer.parseInt(input) - 1].getName();
            ui.showToUser("Oh no! You have deleted " + fileName);
            listOfFiles[Integer.parseInt(input) - 1].delete();
            logger.log(Level.INFO, "Deleted Diet Session successfully");
        } catch (NumberFormatException e) {
            ui.showToUser("Wrong format, please enter in the format:\n\t "
                    + "delete [INDEX_OF_SESSION]");
            logger.log(Level.INFO, "No or wrong index for deletion in dietManager");
        } catch (IndexOutOfBoundsException e) {
            ui.showToUser("Sorry, there is no file at that index.");
            logger.log(Level.INFO, "No input for session index");
        }
    }
}
