package commands.workout.workoutmanager;

import commands.Command;
import commands.ExecutionResult;
import storage.workout.WorkOutManagerStorage;

import static commands.ExecutionResult.OK;
import static logger.SchwarzeneggerLogger.logger;

public class ListWS extends Command {
    @Override
    public ExecutionResult execute(String[] args) {
        WorkOutManagerStorage.list(args);
        logger.info("listed successfully");
        return OK;
    }
}
