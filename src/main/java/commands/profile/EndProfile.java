package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.profile.RedundantParamException;
import logger.SchwarzeneggerLogger;
import storage.profile.ProfileStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static profile.Constants.COMMAND_WORD_END;
import static profile.Constants.MESSAGE_EXIT_PROFILE;

/**
 * A representation of the command for exiting Profile session.
 */
public class EndProfile extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

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
     * Overrides execute method of class Command to execute end command requested by user's input.
     *
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(ProfileStorage storage) {
        logger.log(Level.INFO, "executing End Command");
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
