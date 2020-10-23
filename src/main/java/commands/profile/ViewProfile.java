package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.RedundantParamException;
import logger.SchwarzeneggerLogger;
import profile.Profile;
import storage.profile.ProfileStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static commands.ExecutionResult.FAILED;
import static profile.Constants.COMMAND_WORD_VIEW;
import static profile.Constants.MESSAGE_PROFILE_NOT_EXIST;
import static profile.Constants.MESSAGE_VIEW_PROFILE;

/**
 * A representation of the command for viewing profile.
 */
public class ViewProfile extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    /**
     * Constructs ViewCommand object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to View Command.
     */
    public ViewProfile(String commandArgs) throws RedundantParamException {
        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_VIEW);
        }
    }

    /**
     * Overrides execute method of class Command to execute the view profile command requested by user's input.
     *
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "executing View Command");

        Profile profile = storage.loadData();
        if (profile == null) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_VIEW), FAILED);
        } else {
            return new CommandResult(String.format(MESSAGE_VIEW_PROFILE, profile.toString()));
        }
    }
}
