package commands.diet.dietmanager;

import commands.Command;
import diet.dietmanager.DietManagerParser;
import diet.dietsession.DietSession;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import storage.diet.DietStorage;

import java.io.IOException;
import java.util.logging.Level;

public class DietSessionCreate extends Command {

    private final DietManagerParser parser = new DietManagerParser();

    /**
     * Overrides execute for create command to create new diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {

        try {
            StringBuilder message = new StringBuilder();
            String dateInput = parser.extractDate(input, message);
            String typeInput = parser.extractMeal(input, message);

            ui.showToUser(message.deleteCharAt(message.length() - 1).toString());
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
            ui.showToUser("Failed to save your diet session!");
        }
    }
}
