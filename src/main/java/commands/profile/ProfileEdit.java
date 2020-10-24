package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import logger.SchwarzeneggerLogger;
import profile.Profile;
import storage.profile.ProfileStorage;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static profile.Constants.COMMAND_WORD_EDIT;
import static profile.Constants.MESSAGE_EDIT_PROFILE_ACK;
import static profile.Constants.MESSAGE_PROFILE_NOT_EXIST;
import static profile.ProfileParser.extractAge;
import static profile.ProfileParser.extractCommandTagAndInfo;
import static profile.ProfileParser.extractExpectedWeight;
import static profile.ProfileParser.extractHeight;
import static profile.ProfileParser.extractName;
import static profile.ProfileParser.extractWeight;

/**
 * A representation of the command for editing profile.
 */
public class ProfileEdit extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    
    /**
     * Overrides execute method of class Command to execute the edit profile command requested by user's input.
     *
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "executing Edit Command");

        Profile profile;
        try {
            profile = storage.loadData();

            HashMap<String, String> parsedParams = extractCommandTagAndInfo(COMMAND_WORD_EDIT, commandArgs);
            String name = parsedParams.containsKey("/n") ? extractName(parsedParams) : profile.getName();
            int age = parsedParams.containsKey("/a") ? extractAge(parsedParams) : profile.getAge();
            int height = parsedParams.containsKey("/h") ? extractHeight(parsedParams) : profile.getHeight();
            double weight = parsedParams.containsKey("/w") ? extractWeight(parsedParams) : profile.getWeight();
            double expectedWeight = parsedParams.containsKey("/e")
                    ? extractExpectedWeight(parsedParams) : profile.getExpectedWeight();

            profile = new Profile(name, age, height, weight, expectedWeight);
            storage.saveData(profile);

            return new CommandResult(String.format(MESSAGE_EDIT_PROFILE_ACK, profile.toString()), OK);
        } catch (InvalidSaveFormatException e) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_EDIT), FAILED);
        }
    }
}
