package commands.main;

import commands.Command;
import commands.CommandResult;
import exceptions.InvalidCommandWordException;
import ui.CommonUi;

public class Wrong extends Command {

    CommonUi ui = new CommonUi();

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
