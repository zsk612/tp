package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.logging.Level;

import static commands.ExecutionResult.MISSING;
import static logger.SchwarzeneggerLogger.logger;
import static ui.workout.workoutmanager.WorkoutManagerUi.COMMAND_NOT_FOUND;

public class WrongWS extends Command {
    @Override
    public CommandResult execute(String[] args) {
        logger.log(Level.WARNING, "command not recognised");
        WorkoutManagerUi.commandNotFoundResponse();
        return new CommandResult(COMMAND_NOT_FOUND, MISSING);
    }
}
