package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;
import exceptions.profile.RedundantParamException;
import logger.SchwarzeneggerLogger;
import storage.profile.ProfileStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static profile.Constants.COMMAND_WORD_END;

/**
 * A representation of the command for exiting Profile session.
 */
public class ProfileEnd extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    /**
     * Overrides execute method of class Command to execute end command requested by user's input.
     *
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "executing End Command");

        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_END);
        }

        throw new EndException();
    }
}
