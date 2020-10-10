package profile.commands;

import profile.components.Profile;
import profile.exceptions.RedundantParamException;
import profile.exceptions.SchwarzeneggerException;
import profile.storage.Storage;

import static profile.components.Constants.COMMAND_WORD_DELETE;
import static profile.components.Constants.MESSAGE_DELETE_PROFILE;

/**
 * A representation of the command for deleting user profile.
 */
public class DeleteCommand extends Command {

    /**
     * Constructs DeleteCommand object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to Delete Command.
     */
    public DeleteCommand(String commandArgs) throws RedundantParamException {
        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_DELETE);
        }
    }

    /**
     * Overrides execute method of class Command to execute the delete profile command requested by user's input.
     *
     * @param profile User's Profile object.
     * @param storage Storage to delete data.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(Profile profile, Storage storage) {
        try {
            profile.isDeleted = true;
            storage.saveData(profile);
            return new CommandResult(MESSAGE_DELETE_PROFILE);
        } catch (SchwarzeneggerException e) {
            return new CommandResult(e.getMessage());
        }
    }

    /**
     * Checks if user wants to delete profile by checking given command.
     *
     * @param command The command to be checked.
     * @return Whether the command is an object of type DeleteCommand.
     */
    public static boolean isDelete(Command command) {
        return command instanceof DeleteCommand;
    }
}
