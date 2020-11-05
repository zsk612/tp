package logic.commands.diet.dietmanager;


import diet.dietmanager.DietManagerParser;
import diet.dietsession.DietSession;
import exceptions.InvalidDateFormatException;
import exceptions.profile.InvalidCommandFormatException;
import logic.commands.Command;
import logic.commands.CommandResult;
import storage.diet.DietStorage;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import static ui.diet.dietmanager.DietManagerUi.DIET_CREATE_WRONG_FORMAT;
import static ui.diet.dietmanager.DietManagerUi.DIET_DATE_WRONG_FORMAT;
import static ui.diet.dietmanager.DietManagerUi.DIET_NEW_SUCCESS;

//@@author CFZeon
public class DietSessionCreate extends Command {

    private final DietManagerParser parser = new DietManagerParser();

    /**
     * Overrides execute for create command to create new diet sessions.
     *
     * @param input   user input for command
     * @param storage storage for diet manager
     * @return CommandResult with ended diet session message
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) {
        String result = "";
        try {
            StringBuilder message = new StringBuilder();
            HashMap<String, String> parsedParams = parser.extractDietManagerCommandTagAndInfo("new", input);
            // extract the date and tags and assigns it to the string
            String date = parser.extractNewDate(parsedParams, message);
            String tag = parser.extractNewTag(parsedParams, message);
            if (message.length() != 0) {
                ui.showToUser(message.toString().trim());
            }
            DietSession ds = new DietSession(tag, date, true, -1);
            assert ds != null : "Diet session constructed without error";
            logger.log(Level.INFO, "Diet session successfully created");
            ds.start(true, -1);
            result = DIET_NEW_SUCCESS;
        } catch (IOException e) {
            result = "It seems like we ran into some problems saving your session...";
        } catch (InvalidDateFormatException e) {
            logger.log(Level.WARNING, "Wrong date format");
            result = DIET_DATE_WRONG_FORMAT;
        } catch (InvalidCommandFormatException e) {
            logger.log(Level.WARNING, "Invalid command in dietSessionCreate");
            result = DIET_CREATE_WRONG_FORMAT;
        }
        return new CommandResult(result);
    }
}
