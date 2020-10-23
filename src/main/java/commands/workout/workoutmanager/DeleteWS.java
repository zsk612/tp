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
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

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
