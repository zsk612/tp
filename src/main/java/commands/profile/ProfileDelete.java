package commands.profile;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import exceptions.profile.RedundantParamException;
import models.Profile;
import storage.profile.ProfileStorage;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static profile.Constants.MESSAGE_DELETE_NOTHING;
import static profile.Constants.MESSAGE_DELETE_PROFILE;
import static seedu.duke.Constant.COMMAND_WORD_DELETE;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;

/**
 * A representation of the command for deleting user profile.
 */
public class ProfileDelete extends Command {

    /**
     * Overrides execute method of class Command to execute the delete profile command requested by user's input.
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
            throw new RedundantParamException(COMMAND_WORD_DELETE);
        }

        Profile profile;
        try {
            profile = storage.loadData();

            if (!ui.checkConfirmation("Profile Menu", "clear your profile")) {
                return new CommandResult(CLEAR_ABORTED, ExecutionResult.ABORTED);
            }

            storage.saveData(null);
            return new CommandResult(MESSAGE_DELETE_PROFILE, OK);
        } catch (InvalidSaveFormatException e) {
            return new CommandResult(MESSAGE_DELETE_NOTHING, FAILED);
        }
    }
}
