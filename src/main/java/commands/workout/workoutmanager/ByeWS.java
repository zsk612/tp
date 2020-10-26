package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;

public class ByeWS extends Command {

    /**
     * Terminates workout manager and return to main menu.
     *
     * @param args Array of user's input.
     * @return null
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String args) throws SchwarzeneggerException {
        super.execute(args);
        throw new EndException();
    }
}
