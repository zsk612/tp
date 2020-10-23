package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import logger.SchwarzeneggerLogger;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.logging.Level;
import java.util.logging.Logger;

import static commands.ExecutionResult.MISSING;
import static ui.workout.workoutmanager.WorkoutManagerUi.COMMAND_NOT_FOUND;

public class WrongWS extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    @Override
    public CommandResult execute(String[] args) {
        logger.log(Level.WARNING, "command not recognised");
        WorkoutManagerUi.commandNotFoundResponse();
        return new CommandResult(COMMAND_NOT_FOUND, MISSING);
    }
}
