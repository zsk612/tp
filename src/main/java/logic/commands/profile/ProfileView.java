package logic.commands.profile;

import diet.dietmanager.DietManager;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import logic.commands.Command;
import logic.commands.CommandResult;
import models.Profile;
import storage.profile.ProfileStorage;

import java.time.LocalDate;

import static logic.commands.ExecutionResult.FAILED;
import static seedu.duke.Constant.COMMAND_WORD_VIEW;
import static seedu.duke.Constant.PATH_TO_DIET_FOLDER;
import static ui.profile.ProfileUi.MESSAGE_ENOUGH_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_MORE_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_PROFILE_NOT_EXIST;
import static ui.profile.ProfileUi.MESSAGE_VIEW_PROFILE;

//@@author tienkhoa16

/**
 * A representation of the command for viewing profile.
 */
public class ProfileView extends Command {
    private String pathToDietData;
    private LocalDate date;

    /**
     * Constructs ProfileView object.
     *
     * @param pathToDietData Path to diet folder to get total calories.
     * @param date Date to get total calories.
     */
    public ProfileView(String pathToDietData, LocalDate date) {
        super();
        this.pathToDietData = pathToDietData;
        this.date = date;
    }

    /**
     * Constructs ProfileView object with default path to data file and current date.
     */
    public ProfileView() {
        this(PATH_TO_DIET_FOLDER, LocalDate.now());
    }

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

            double totalCalories = new DietManager().getDateTotalCalories(pathToDietData, date);
            double caloriesToGoal = profile.getCalories() - totalCalories;

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
