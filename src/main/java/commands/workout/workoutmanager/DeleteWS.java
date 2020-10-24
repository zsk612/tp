package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import exceptions.workoutmanager.InsufficientArgumentException;
import exceptions.workoutmanager.NotANumberException;
import exceptions.workoutmanager.OutOfArrayException;
import logger.SchwarzeneggerLogger;
import models.PastRecordList;

import java.util.logging.Logger;

import static ui.workout.workoutmanager.WorkoutManagerUi.DELETE_SUCCESS;

public class DeleteWS extends Command {

    /**
     * Delete a record at a specific index.
     * @param args index of the record to be removed
     * @return Status OK and feedback message if file is deleted
     * @throws SchwarzeneggerException Throw NotANumberException if input is not a number
     *         Throw InsufficientArgumentException if input is not sufficient
     *         Throw OutOfArrayException if index is out of bound
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
