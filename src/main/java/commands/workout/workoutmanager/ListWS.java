package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;

import static commands.ExecutionResult.OK;

public class ListWS extends Command {

    /**
     * Lists past record of workout sessions.
     *
     * @param args Array of user's input.
     * @return Status OK and all past records in a table.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        String formattedInfo = PastRecordList.getInstance().list(args);
        logger.info("Listed successfully");
        return new CommandResult(formattedInfo, OK);
    }
}
