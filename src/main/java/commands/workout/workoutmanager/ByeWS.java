package commands.workout.workoutmanager;

import commands.Command;
import commands.ExecutionResult;
import ui.workout.workoutmanager.WorkoutManagerUi;
import workout.workoutmanager.ExitException;

import static logger.SchwarzeneggerLogger.logger;

public class ByeWS extends Command {

    @Override
    public ExecutionResult execute(String[] args) {
        logger.info("bye command carried out");
        throw new ExitException();
    }

    @Override
    public void printResponse() {
        WorkoutManagerUi.printBye();
    }
}
