package commands.diet.dietmanager;

import commands.Command;
import diet.dietsession.DietSession;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;
import storage.diet.Storage;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionCreate extends Command {

    private final DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for create command to create new diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {

        try {
            DietSession ds = new DietSession(ui.extractMeal(input), ui.extractDate(input));
            assert ds != null;
            logger.log(Level.INFO, "Diet session successfully created");
            ds.start();
            saveToFile(storage, ds);
        } catch (IOException e) {
            System.out.println("It seems like we ran into some problems saving your session...");
            logger.log(Level.WARNING, "Diet session failed to save");
        }
    }

    /**
     * constructs method to save changes to storage file.
     *
     * @param storage storage for diet manager
     * @param ds dietSession that is being changed
     */
    private void saveToFile(Storage storage, DietSession ds) {
        try {
            storage.init(ds.getDate().toString() + " " + ds.getTypeInput());
            storage.writeToStorageDietSession(ds.getDate().toString() + " " + ds.getTypeInput(), ds);
            logger.log(Level.INFO, "Diet session successfully saved");
        } catch (IOException e) {
            logger.log(Level.WARNING, "save profile session failed");
            System.out.println("Failed to save your diet session!");
        }
    }
}
