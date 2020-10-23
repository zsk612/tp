package commands.diet.dietmanager;

import commands.Command;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DietSessionSearch extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    static final String FILEPATH = "saves/diet/";
    DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for search command to search diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {

        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        assert folder.exists();
        try {
            ui.showToUser("Here are the search results!");
            if (Objects.requireNonNull(listOfFiles).length == 0) {
                ui.showToUser("It seems like you do not have any meal sessions stored!");
            }
            int numberOfResults = 0;
            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                if (listOfFiles[i].getName().contains(input.trim())) {
                    System.out.println("\t" + (++numberOfResults) + ". "
                            + listOfFiles[i].getName().replaceFirst("[.][^.]+$", ""));
                }
            }
            if (numberOfResults == 0) {
                ui.showToUser("Sorry, there is nothing found in your diet manager.");
            }
            logger.log(Level.INFO, "Listed all searched diet sessions");
        } catch (NullPointerException e) {
            ui.showToUser("\tSorry! It seems like you have no meal sessions saved!.");
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
    }
}
