package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.profile.RedundantParamException;
import profile.Profile;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.COMMAND_WORD_VIEW;
import static profile.Constants.MESSAGE_PROFILE_NOT_EXIST;
import static profile.Constants.MESSAGE_VIEW_PROFILE;

/**
 * A representation of the command for viewing profile.
 */
public class ViewProfile extends Command {

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
     * @param profile User's Profile object.
     * @return Result of command execution.
     */
    @Override
    public Profile execute(Profile profile) {
        logger.log(Level.INFO, "executing View Command");
        return profile;
    }

    /**
     * Overrides getExecutionResult method of class Command to get execution result after executing view command.
     *
     * @param profile User's profile.
     * @return Execution result.
     */
    @Override
    public CommandResult getExecutionResult(Profile profile) {
        if (profile == null) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_VIEW));
        }
        return new CommandResult(String.format(MESSAGE_VIEW_PROFILE, profile.toString()));
    }
}
