package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import models.PastRecordList;

public class SearchWS extends Command {

    @Override
    public CommandResult execute(String[] args) {
        String formattedInfo = PastRecordList.getInstance().search(args);

        return new CommandResult(formattedInfo, ExecutionResult.OK);
    }
}
