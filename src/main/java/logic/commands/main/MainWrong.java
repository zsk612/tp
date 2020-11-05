package logic.commands.main;

import logic.commands.Command;
import logic.commands.CommandResult;
import exceptions.InvalidCommandWordException;

/**
 * A representation of invalid command in Main Menu.
 */
public class MainWrong extends Command {

    /**
     * Notifies user invalid input command.
     *
     * @param args User's input.
     * @return Invalid input command message.
     */
    @Override
    public CommandResult execute(String args) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
