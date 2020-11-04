package logic.commands.profile;

import logic.commands.Command;
import logic.commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;
import storage.profile.ProfileStorage;

/**
 * A representation of the command for exiting Profile Menu.
 */
public class ProfileEnd extends Command {

    /**
     * Overrides execute method of class Command to execute end command requested by user's input.
     *
     * @param commandArgs User's input arguments.
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        super.execute(commandArgs, storage);

        if (!commandArgs.isEmpty()) {
            ui.showWarning("\"end\" command does not take in parameters");
        }

        throw new EndException();
    }
}
