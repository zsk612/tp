package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import storage.workout.WorkOutManagerStorage;

import static commands.ExecutionResult.OK;
import static logger.SchwarzeneggerLogger.logger;

public class ListWS extends Command {
    @Override
    public CommandResult execute(String[] args) {
        String formatedInfo = WorkOutManagerStorage.list(args);
        logger.info("listed successfully");
        return new CommandResult(formatedInfo, OK);
    }
}
