package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import logger.SchwarzeneggerLogger;
import models.PastRecordList;

import java.util.logging.Logger;

import static commands.ExecutionResult.OK;

public class ListWS extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    @Override
    public CommandResult execute(String[] args) {
        String formattedInfo = PastRecordList.getInstance().list(args);
        logger.info("listed successfully");
        return new CommandResult(formattedInfo, OK);
    }
}
