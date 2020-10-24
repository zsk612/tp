package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import workout.workoutmanager.ExitException;

import java.util.logging.Logger;

public class ByeWS extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    /**
     * Terminate workout manager and return to main menu.
     * @param args user inputs into a list of string
     * @return null
     * @throws SchwarzeneggerException null
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        throw new ExitException();
    }
}
