package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidCommandWordException;
import storage.profile.ProfileStorage;

import java.util.logging.Level;

/**
 * A representation of the command for invalid command.
 */
public class ProfileWrong extends Command {

    /**
     * Notifies user invalid input command.
     *
     * @param commandArgs User's input arguments.
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.WARNING, "command not recognised");
        throw new InvalidCommandWordException();
    }
}
