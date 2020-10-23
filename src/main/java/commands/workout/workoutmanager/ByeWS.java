package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import ui.workout.workoutmanager.WorkoutManagerUi;
import workout.workoutmanager.ExitException;

import static logger.SchwarzeneggerLogger.logger;

public class ByeWS extends Command {

    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        logger.info("bye command carried out");
        throw new ExitException();
    }
}
