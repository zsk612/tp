package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import exceptions.WorkoutManager.InsufficientArgumentException;
import exceptions.WorkoutManager.NotANumberException;
import exceptions.WorkoutManager.OutOfArrayException;
import storage.workout.WorkOutManagerStorage;

import static logger.SchwarzeneggerLogger.logger;
import static ui.workout.workoutmanager.WorkoutManagerUi.DELETE_SUCCESS;

public class DeleteWS extends Command {

    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        logger.info("entering delete command");
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
        try{
            WorkOutManagerStorage.delete(index);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Index Out Of Bounds Exception caught");
            throw new OutOfArrayException();
        }
        logger.info("deleted successfully");
        return new CommandResult(DELETE_SUCCESS, ExecutionResult.OK);
    }
}
