package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import exceptions.profile.RedundantParamException;
import logger.SchwarzeneggerLogger;
import profile.Profile;
import storage.profile.ProfileStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static profile.Constants.COMMAND_WORD_DELETE;
import static profile.Constants.MESSAGE_DELETE_NOTHING;
import static profile.Constants.MESSAGE_DELETE_PROFILE;

/**
 * A representation of the command for deleting user profile.
 */
public class ProfileDelete extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    /**
     * Overrides execute method of class Command to execute the delete profile command requested by user's input.
     *
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "executing Delete Command");

        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_DELETE);
        }

        Profile profile;
        try {
            profile = storage.loadData();
            storage.saveData(null);
            return new CommandResult(MESSAGE_DELETE_PROFILE, OK);
        } catch (InvalidSaveFormatException e) {
            return new CommandResult(MESSAGE_DELETE_NOTHING, FAILED);
        }
    }
}
