package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import models.PastRecordList;
import storage.workout.WorkOutManagerStorage;

public class SearchWS extends Command {

    @Override
    public CommandResult execute(String[] args) {
        String formatedInfo = PastRecordList.getInstance().search(args);

        return new CommandResult(formatedInfo, ExecutionResult.OK);
    }
}
