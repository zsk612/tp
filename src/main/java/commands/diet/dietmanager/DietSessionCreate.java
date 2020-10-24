package commands.diet.dietmanager;

import commands.Command;
import diet.dietsession.DietSession;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.IOException;
import java.util.logging.Level;

public class DietSessionCreate extends Command {

    private final DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for create command to create new diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {

        try {
            String typeInput = ui.extractMeal(input);
            String dateInput = ui.extractDate(input);
            DietSession ds = new DietSession(typeInput, dateInput, true, -1);
            assert ds != null;
            logger.log(Level.INFO, "Diet session successfully created");
            ds.start(true, -1);
            saveToFile(storage, ds);
        } catch (IOException e) {
            ui.showToUser("It seems like we ran into some problems saving your session...");
        } catch (SchwarzeneggerException e) {
            ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
        }
    }

    /**
     * Constructs method to save changes to storage file.
     *
     * @param storage storage for diet manager
     * @param ds dietSession that is being changed
     */
    private void saveToFile(DietStorage storage, DietSession ds) {
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
