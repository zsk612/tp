package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionSearch extends Command {
    static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for search command to search diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {

        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        assert folder.exists();
        try {
            System.out.println("Here are the search results!");
            if (Objects.requireNonNull(listOfFiles).length == 0) {
                System.out.println("It seems like you do not have any meal sessions stored!");
            }
            int numberOfResults = 0;
            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                if (listOfFiles[i].getName().contains(input.trim())) {
                    System.out.println((++numberOfResults) + ". "
                            + listOfFiles[i].getName().replaceFirst("[.][^.]+$", ""));
                }
            }
            if (numberOfResults == 0) {
                System.out.println("Sorry, there is nothing found in your diet manager.");
            }
            logger.log(Level.INFO, "Listed all searched diet sessions");
        } catch (NullPointerException e) {
            System.out.println("Sorry! It seems like you have no meal sessions saved!.");
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
    }
}
