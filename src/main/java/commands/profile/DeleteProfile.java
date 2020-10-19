package commands.profile;

import exceptions.SchwarzeneggerException;
import exceptions.profile.RedundantParamException;
import profile.Profile;
import storage.profile.Storage;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.COMMAND_WORD_DELETE;
import static profile.Constants.MESSAGE_DELETE_PROFILE;

/**
 * A representation of the command for deleting user profile.
 */
public class DeleteProfile extends Command {

    /**
     * Constructs DeleteCommand object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to Delete Command.
     */
    public DeleteProfile(String commandArgs) throws RedundantParamException {
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
            logger.log(Level.INFO, "executing DeleteCommand");
            profile.isDeleted = true;
            storage.saveData(profile);
            return new CommandResult(MESSAGE_DELETE_PROFILE);
        } catch (SchwarzeneggerException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
