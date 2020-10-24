package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import profile.Profile;
import storage.profile.ProfileStorage;

import java.util.HashMap;
import java.util.logging.Level;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static profile.Constants.MESSAGE_CREATE_PROFILE_ACK;
import static profile.Constants.MESSAGE_PROFILE_EXIST;
import static profile.ProfileParser.extractAge;
import static profile.ProfileParser.extractCommandTagAndInfo;
import static profile.ProfileParser.extractExpectedWeight;
import static profile.ProfileParser.extractHeight;
import static profile.ProfileParser.extractName;
import static profile.ProfileParser.extractWeight;
import static seedu.duke.Constant.COMMAND_WORD_ADD;

/**
 * A representation of the command for adding profile.
 */
public class ProfileAdd extends Command {

    /**
     * Overrides execute method of class Command to execute the add profile command requested by user's input.
     *
     * @param commandArgs User's input arguments.
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "executing Add Command");

        Profile profile;
        try {
            profile = storage.loadData();
            return new CommandResult(MESSAGE_PROFILE_EXIST, FAILED);
        } catch (InvalidSaveFormatException e) {
            HashMap<String, String> parsedParams = extractCommandTagAndInfo(COMMAND_WORD_ADD, commandArgs);
            profile = new Profile(
                    extractName(parsedParams),
                    extractAge(parsedParams),
                    extractHeight(parsedParams),
                    extractWeight(parsedParams),
                    extractExpectedWeight(parsedParams)
            );
            storage.saveData(profile);
            return new CommandResult(String.format(MESSAGE_CREATE_PROFILE_ACK, profile.toString()), OK);
        }
    }
}
