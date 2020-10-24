package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.logging.Level;
import java.util.logging.Logger;

import static commands.ExecutionResult.MISSING;
import static ui.workout.workoutmanager.WorkoutManagerUi.COMMAND_NOT_FOUND;

public class WrongWS extends Command {

    /**
     * Notifies user invalid input command.
     *
     * @param args User's input arguments.
     * @return Status MISSING and COMMAND_NOT_FOUND feedback.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        return new CommandResult(COMMAND_NOT_FOUND, MISSING);
    }
}
