package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;

import static commands.ExecutionResult.OK;

public class ListWS extends Command {

    /**
     * Constructor of ListWS.
     * @param args null
     * @return Status OK and all past record in a table
     * @throws SchwarzeneggerException null
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        String formattedInfo = PastRecordList.getInstance().list(args);
        logger.info("Listed successfully");
        return new CommandResult(formattedInfo, OK);
    }
}
