package logic.commands.diet.dietmanager;

import logic.commands.Command;
import storage.diet.DietStorage;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

public class DietSessionClear extends Command {

    private static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for clear command to clear all diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {
        try {
            if (ui.checkConfirmation("Diet Menu", "clear all records")) {
                File folder = new File(FILEPATH);
                File[] listOfFiles = folder.listFiles();
                for (int index = 0; index < Objects.requireNonNull(listOfFiles).length; index++) {
                    listOfFiles[index].delete();
                }
                ui.showToUser("Alright, your diet sessions have been cleared.");
                logger.log(Level.INFO, "Cleared all diet sessions");
            } else {
                ui.showToUser("You have aborted clear operation.");
            }
        } catch (NullPointerException e) {
            ui.showToUser("Sorry, there is no diet session to be cleared!");
            logger.log(Level.INFO, "No sessions in dietManager for deletion");
        }
    }
}
