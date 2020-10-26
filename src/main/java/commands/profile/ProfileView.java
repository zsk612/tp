package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import exceptions.profile.RedundantParamException;
import models.Profile;
import storage.profile.ProfileStorage;

import static commands.ExecutionResult.FAILED;
import static profile.Constants.MESSAGE_PROFILE_NOT_EXIST;
import static profile.Constants.MESSAGE_VIEW_PROFILE;
import static seedu.duke.Constant.COMMAND_WORD_VIEW;

/**
 * A representation of the command for viewing profile.
 */
public class ProfileView extends Command {

    /**
     * Overrides execute method of class Command to execute the view profile command requested by user's input.
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
            throw new RedundantParamException(COMMAND_WORD_VIEW);
        }

        Profile profile;
        try {
            profile = storage.loadData();
            return new CommandResult(String.format(MESSAGE_VIEW_PROFILE, profile.toString()));
        } catch (InvalidSaveFormatException e) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_VIEW), FAILED);
        }
    }
}
