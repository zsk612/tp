package logic.commands.diet.dietmanager;

import logic.commands.Command;
import logic.commands.CommandResult;
import storage.diet.DietStorage;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

import static seedu.duke.Constant.PATH_TO_DIET_FOLDER;
import static ui.CommonUi.clearMsg;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;

//@@author CFZeon
public class DietSessionClear extends Command {
    /**
     * Overrides execute for clear command to clear all diet sessions.
     *
     * @param input   user input for command
     * @param storage storage for diet manager
     * @return CommandResult instance
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) {
        String resultMessage = "";
        try {
            if (ui.checkConfirmation("Diet Menu", "clear all records")) {
                File folder = new File(PATH_TO_DIET_FOLDER);
                File[] listOfFiles = folder.listFiles();
                for (int index = 0; index < Objects.requireNonNull(listOfFiles).length; index++) {
                    listOfFiles[index].delete();
                }
                resultMessage = clearMsg("diet sessions have");
                logger.log(Level.INFO, "Cleared all diet sessions");
            } else {
                resultMessage = CLEAR_ABORTED;
            }
        } catch (NullPointerException e) {
            resultMessage = "Sorry, there is no diet session to be cleared!";
            logger.log(Level.INFO, "No sessions in dietManager for deletion");
        }
        return new CommandResult(resultMessage);
    }
}
