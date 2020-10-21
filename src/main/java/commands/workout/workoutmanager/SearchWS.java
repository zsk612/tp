package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import storage.workout.WorkOutManagerStorage;

public class SearchWS extends Command {

    @Override
    public CommandResult execute(String[] args) {
        String formatedInfo = WorkOutManagerStorage.search(args);

        return new CommandResult(formatedInfo, ExecutionResult.OK);
    }
}
