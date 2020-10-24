package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;

import java.util.logging.Logger;

public class ByeWS extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        logger.info("bye command carried out");
        throw new EndException();
    }
}
