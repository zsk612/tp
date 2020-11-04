package commands.diet.dietmanager;

import commands.Command;
import commands.CommandResult;
import storage.diet.DietStorage;
import static ui.CommonUi.clearMsg;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

public class DietSessionClear extends Command {

    private static final String FILEPATH = "saves/diet/";

    /**
     * Overrides execute for clear command to clear all diet sessions.
     *  @param input user input for command
     * @param storage storage for diet manager
     * @return CommandResult instance
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) {
        String resultMessage = "";
        try {
            if (ui.checkConfirmation("Diet Menu", "clear all records")) {
                File folder = new File(FILEPATH);
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
