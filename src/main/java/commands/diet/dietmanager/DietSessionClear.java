package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionClear extends Command {
    static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for clear command to clear all diet sessions.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        try {
            File folder = new File(FILEPATH);
            File[] listOfFiles = folder.listFiles();
            for (int index = 0; index < Objects.requireNonNull(listOfFiles).length; index++) {
                listOfFiles[index].delete();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.log(Level.INFO, "No sessions in dietManager for deletion");
        }
        System.out.println("You have cleared all diet sessions!");
        logger.log(Level.INFO, "Cleared all diet sessions");
    }
}
