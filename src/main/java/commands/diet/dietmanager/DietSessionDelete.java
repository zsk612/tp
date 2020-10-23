package commands.diet.dietmanager;

import commands.Command;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DietSessionDelete extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    static final String FILEPATH = "saves/diet/";
    DietManagerUi ui = new DietManagerUi();

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
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            ui.showToUser("Sorry! It seems like you've entered an invalid number or input!");
            logger.log(Level.INFO, "No or wrong index for deletion in dietManager");
        }
    }
}
