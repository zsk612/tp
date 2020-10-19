package commands.profile;

import exceptions.profile.RedundantParamException;
import profile.Profile;
import storage.profile.Storage;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.COMMAND_WORD_ADD;
import static profile.Constants.MESSAGE_ADD_TITLE;
import static profile.Constants.MESSAGE_PROFILE_EXIST;

/**
 * A representation of the command for adding profile.
 */
public class AddProfile extends Command {

    /**
     * Constructs AddCommand object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to Add Command.
     */
    public AddProfile(String commandArgs) throws RedundantParamException {
        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_ADD);
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
        logger.log(Level.INFO, "executing AddCommand");
        if (!profile.isDeleted) {
            return new CommandResult(MESSAGE_PROFILE_EXIST);
        }
        return new CommandResult(MESSAGE_ADD_TITLE);
    }

    /**
     * Checks if user wants to add profile by checking given command.
     *
     * @param command The command to be checked.
     * @return Whether the command is an object of type AddCommand.
     */
    public static boolean isAddCommand(Command command) {
        return command instanceof AddProfile;
    }
}
