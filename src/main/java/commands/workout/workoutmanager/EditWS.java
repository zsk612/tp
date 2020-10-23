package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import exceptions.workoutmanager.InsufficientArgumentException;
import exceptions.workoutmanager.NotANumberException;
import exceptions.workoutmanager.OutOfArrayException;
import models.PastRecordList;
import storage.workout.WorkOutManagerStorage;
import workout.workoutsession.WorkoutSession;

import static logger.SchwarzeneggerLogger.logger;
import static ui.workout.workoutmanager.WorkoutManagerUi.EDIT_SUCCESS;

public class EditWS extends Command {

    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        logger.info("entering edit command");
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

        String filePath;
        try {
            filePath = PastRecordList.getInstance().edit(index);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Index Out Of Bounds Exception caught");
            throw new OutOfArrayException();
        }
        WorkoutSession ws = new WorkoutSession(filePath);
        logger.info("editing workout session created");
        ws.workoutSessionStart();

        logger.info("edit successfully");
        return new CommandResult(EDIT_SUCCESS, ExecutionResult.OK);
    }

}
