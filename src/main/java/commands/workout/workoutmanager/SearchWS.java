package commands.workout.workoutmanager;

import commands.Command;
import commands.ExecutionResult;
import storage.workout.WorkOutManagerStorage;

public class SearchWS extends Command {

    @Override
    public ExecutionResult execute(String[] args) {
        WorkOutManagerStorage.search(args);
        return ExecutionResult.OK;
    }
}
