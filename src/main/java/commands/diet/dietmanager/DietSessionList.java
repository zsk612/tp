package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.io.File;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionList extends Command {
    static final String FILEPATH = "saves/diet/";

    @Override
    public void execute(String input, Storage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();

        try {
            assert listOfFiles.length != 0;
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println((i + 1) + ". " + listOfFiles[i].getName());
            }
            logger.log(Level.INFO, "Listed all available diet sessions");
        } catch (NullPointerException e) {
            System.out.println("Sorry, there is nothing in Diet Manager.");
            logger.log(Level.INFO, "No instances of diet sessions saved");
        }
    }
}
