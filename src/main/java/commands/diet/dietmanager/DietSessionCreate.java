package commands.diet.dietmanager;

import commands.Command;
import diet.dietmanager.DietManagerParser;
import diet.dietsession.DietSession;
import exceptions.InvalidDateFormatException;
import exceptions.profile.InvalidCommandFormatException;
import storage.diet.DietStorage;

import java.io.IOException;
import java.util.HashMap;
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
            HashMap<String, String> parsedParams = parser.extractDietManagerCommandTagAndInfo("new", input);
            String date = parser.extractNewDate(parsedParams, message);

            String tag = parser.extractNewTag(parsedParams, message);
            if (message.length() != 0) {
                ui.showToUser(message.toString().trim());
            }
            DietSession ds = new DietSession(tag, date, true, -1);
            assert ds != null;
            logger.log(Level.INFO, "Diet session successfully created");
            ds.start(true, -1);
            saveToFile(storage, ds);
        } catch (IOException e) {
            ui.showToUser("It seems like we ran into some problems saving your session...");
        } catch (InvalidDateFormatException e) {
            logger.log(Level.WARNING, "Wrong date format");
            ui.showToUser("Please key in correct date.");
        } catch (InvalidCommandFormatException e) {
            logger.log(Level.WARNING, "Invalid command in dietSessionCreate");
            ui.showToUser("Wrong format, please enter in the format: \n\t "
                    + "new </d [DATE]> </t [TAG]>");
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
