package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionClear extends Command {
    private static final String FILEPATH = "saves/diet/";
    private final DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for clear command to clear all diet sessions.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        try {
            if (checkConfirmation()) {
                File folder = new File(FILEPATH);
                File[] listOfFiles = folder.listFiles();
                for (int index = 0; index < Objects.requireNonNull(listOfFiles).length; index++) {
                    listOfFiles[index].delete();
                }
            } else {
                System.out.println("You have aborted clear operation.");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.log(Level.INFO, "No sessions in dietManager for deletion");
        }
        System.out.println("You have cleared all diet sessions!");
        logger.log(Level.INFO, "Cleared all diet sessions");
    }

    private boolean checkConfirmation() {
        System.out.println("\tAre you sure you want to clear all records? This action is irrevocable.");
        System.out.println("\tKey in YES to confirm.");
        String input = ui.getCommand("Diet Menu");
        return  input.equals("YES");
    }
}
