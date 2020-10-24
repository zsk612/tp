package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;

public class SearchWS extends Command {

    /**
     * Constructor of SearchWS.
     * @param args user input parsed into a list of strings
     * @return Status OK and information to be printed
     * @throws SchwarzeneggerException null
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {

        super.execute(args);
        String formattedInfo = PastRecordList.getInstance().search(args);
        return new CommandResult(formattedInfo, ExecutionResult.OK);
    }
}
