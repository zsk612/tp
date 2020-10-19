package commands.workout.workoutmanager;

import commands.Command;
import commands.ExecutionResult;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.logging.Level;

import static commands.ExecutionResult.MISSING;
import static logger.SchwarzeneggerLogger.logger;

public class WrongWS extends Command {
    @Override
    public ExecutionResult execute(String[] args) {
        logger.log(Level.WARNING, "command not recognised");
        WorkoutManagerUi.commandNotFoundResponse();
        return MISSING;
    }
}
