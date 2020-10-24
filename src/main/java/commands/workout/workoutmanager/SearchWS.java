package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;

public class SearchWS extends Command {

    /**
     * Searches workout session.
     *
     * @param args Array of user's input.
     * @return Status OK and information to be printed.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {

        super.execute(args);
        String formattedInfo = PastRecordList.getInstance().search(args);
        return new CommandResult(formattedInfo, ExecutionResult.OK);
    }
}
