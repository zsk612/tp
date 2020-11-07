package logic.commands.profile;

import logic.commands.Command;
import logic.commands.CommandResult;
import diet.dietmanager.DietManager;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import models.Profile;
import storage.profile.ProfileStorage;

import static logic.commands.ExecutionResult.FAILED;
import static seedu.duke.Constant.COMMAND_WORD_VIEW;
import static ui.profile.ProfileUi.MESSAGE_ENOUGH_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_MORE_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_PROFILE_NOT_EXIST;
import static ui.profile.ProfileUi.MESSAGE_VIEW_PROFILE;

//@@author tienkhoa16
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
            ui.showWarning("\"view\" command does not take in parameters");
        }

        try {
            Profile profile = storage.loadData();
            assert profile != null : "profile should not be null after loading";

            double todayCalories = new DietManager().getTodayTotalCalories();
            double caloriesToGoal = profile.getCalories() - todayCalories;

            String caloriesMessage;
            if (caloriesToGoal > 0) {
                caloriesMessage = String.format(MESSAGE_MORE_CALORIES, caloriesToGoal);
            } else {
                caloriesMessage = MESSAGE_ENOUGH_CALORIES;
            }

            return new CommandResult(String.format(MESSAGE_VIEW_PROFILE, profile.toString(), caloriesMessage));
        } catch (InvalidSaveFormatException e) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_VIEW), FAILED);
        }
    }
}
