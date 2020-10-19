package commands.profile;

import exceptions.profile.RedundantParamException;
import profile.Profile;
import storage.profile.Storage;

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
     * @param storage Storage to save data when required.
     * @return Result of command execution.
     */
    @Override
    public CommandResult execute(Profile profile, Storage storage) {
        logger.log(Level.INFO, "executing ViewCommand");
        if (profile.isDeleted) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_VIEW));
        }
        return new CommandResult(String.format(MESSAGE_VIEW_PROFILE, profile.toString()));
    }
}
