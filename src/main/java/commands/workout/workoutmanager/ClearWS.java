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
        if (!ui.checkConfirmation("Workout Menu", "clear all records")) {
            return new CommandResult(CLEAR_ABORTED, ExecutionResult.ABORTED);
        }
        PastRecordList.getInstance().clear();
        logger.info("Cleared successfully");
        return new CommandResult(CLEAR_SUCCESS, ExecutionResult.OK);
    }
}
