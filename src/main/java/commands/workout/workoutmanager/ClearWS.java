package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;

import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_SUCCESS;

public class ClearWS extends Command {

    /**
     * Executes all workout sessions.
     *
     * @param args Array of user's input.
     * @return Status OK and feedback message if the execution is affirmed.
     *         Status ABORTED if the execution is withdrawn.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String args) throws SchwarzeneggerException {
        super.execute(args);
        if (!checkConfirmation()) {
            return new CommandResult(CLEAR_ABORTED, ExecutionResult.ABORTED);
        }
        PastRecordList.getInstance().clear();
        logger.info("Cleared successfully");
        return new CommandResult(CLEAR_SUCCESS, ExecutionResult.OK);
    }

    /**
     * Gets user confirmation for clearing all workout sessions.
     *
     * @return If user confirms clearing all workout sessions.
     */
    private static boolean checkConfirmation() {
        System.out.println("\t Are you sure you want to clear all records? This action is irrevocable.");
        System.out.println("\t Key in 'YES' to confirm.");
        String input = ui.getCommand("Workout Manager");
        return input.equals("YES");
    }
}
