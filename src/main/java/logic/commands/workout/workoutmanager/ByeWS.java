package logic.commands.workout.workoutmanager;

import logic.commands.Command;
import logic.commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;

public class ByeWS extends Command {

    /**
     * Terminates workout manager and return to main menu.
     *
     * @param args User's input.
     * @return null.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String args) throws SchwarzeneggerException {
        super.execute(args);
        throw new EndException();
    }
}
