package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.profile.RedundantParamException;
import profile.Profile;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.COMMAND_WORD_END;
import static profile.Constants.MESSAGE_EXIT_PROFILE;

/**
 * A representation of the command for exiting Profile session.
 */
public class EndProfile extends Command {

    /**
     * Constructs EndProfile object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to Exit Command.
     */
    public EndProfile(String commandArgs) throws RedundantParamException {
        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_END);
        }
    }

    /**
     * Overrides execute method of class Command to execute exit command requested by user's input.
     *
     * @param profile User's Profile object.
     * @return Result of command execution.
     */
    @Override
    public Profile execute(Profile profile) {
        logger.log(Level.INFO, "executing ExitCommand");
        return profile;
    }

    public CommandResult getExecutionResult(Profile profile) {
        return new CommandResult(MESSAGE_EXIT_PROFILE);
    }

    /**
     * Checks if user wants to exit Schwarzenegger by checking given command.
     *
     * @param command The command to be checked.
     * @return Whether the command is an object of type EndProfile.
     */
    public static boolean isEnd(Command command) {
        return command instanceof EndProfile;
    }
}
