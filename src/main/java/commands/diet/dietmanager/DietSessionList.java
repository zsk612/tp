package commands.diet.dietmanager;

import commands.Command;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

public class DietSessionList extends Command {

    static final String FILEPATH = "saves/diet/";
    DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for list command to list diet sessions.
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
            ui.showToUser("Here are all the saved meal sessions!");
            if (Objects.requireNonNull(listOfFiles).length == 0) {
                ui.showToUser("It seems like you do not have any meal sessions stored!");
            }
            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                System.out.println("\t" + (i + 1) + ". "
                        + listOfFiles[i].getName().replaceFirst("[.][^.]+$", ""));
            }
            logger.log(Level.INFO, "Listed all available diet sessions");
        } catch (NullPointerException e) {
            ui.showToUser("Sorry! It seems like you have no meal sessions saved!.");
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
    }
}
