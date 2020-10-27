package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import exceptions.workout.workoutmanager.OutOfArrayException;
import models.PastRecordList;
import workout.workoutmanager.WorkoutManagerParser;

import static ui.workout.workoutmanager.WorkoutManagerUi.DELETE_SUCCESS;

public class DeleteWS extends Command {

    /**
     * Deletes a record at a specific index.
     *
     * @param args User's input.
     * @return Status OK and feedback message if file is deleted.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String args) throws SchwarzeneggerException {
        super.execute(args);
        int index = WorkoutManagerParser.parseIndex(args);
        try {
            PastRecordList.getInstance().delete(index);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfArrayException();
        }
        logger.info("deleted successfully");
        return new CommandResult(DELETE_SUCCESS, ExecutionResult.OK);
    }
}
