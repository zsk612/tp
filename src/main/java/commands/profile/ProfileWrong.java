package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.InvalidCommandWordException;
import exceptions.SchwarzeneggerException;
import storage.profile.ProfileStorage;

/**
 * A representation of invalid command in Profile Menu.
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
        super.execute(commandArgs, storage);
        throw new InvalidCommandWordException();
    }
}
