package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.io.File;
import java.util.logging.Level;
import static logger.SchwarzeneggerLogger.logger;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionDelete extends Command {
    static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for delete command to delete diet sessions.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        try {
            assert !input.isEmpty() : "No files to delete or wrong folder";
            assert listOfFiles != null;
            String fileName = listOfFiles[Integer.parseInt(input) - 1].getName();
            System.out.println("Oh no! You have deleted " + fileName);
            listOfFiles[Integer.parseInt(input) - 1].delete();
            logger.log(Level.INFO, "Deleted Diet Session successfully");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
            logger.log(Level.INFO, "No or wrong index for deletion in dietManager");
        }
    }
}
