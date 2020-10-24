package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import exceptions.workoutmanager.InsufficientArgumentException;
import exceptions.workoutmanager.NotANumberException;
import exceptions.workoutmanager.OutOfArrayException;
import models.PastRecordList;

import static ui.workout.workoutmanager.WorkoutManagerUi.DELETE_SUCCESS;

public class DeleteWS extends Command {

    /**
     * Deletes a record at a specific index.
     *
     * @param args Array of user's input.
     * @return Status OK and feedback message if file is deleted.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        int index = -1;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.warning("Number format exception caught");
            throw new NotANumberException();
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Insufficient arguments given!");
            throw new InsufficientArgumentException();
        }
        try {
            PastRecordList.getInstance().delete(index);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Index Out Of Bounds Exception caught");
            throw new OutOfArrayException();
        }
        logger.info("deleted successfully");
        return new CommandResult(DELETE_SUCCESS, ExecutionResult.OK);
    }
}
