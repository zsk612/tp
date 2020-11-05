package logic.commands.diet.dietmanager;

import exceptions.InvalidCommandWordException;
import logic.commands.Command;
import logic.commands.CommandResult;
import storage.diet.DietStorage;

//@@author CFZeon
public class DietSessionWrong extends Command {

    /**
     * Overrides execute for wrong command.
     *
     * @param input   user input for command.
     * @param storage storage for diet manager.
     * @return CommandResult with invalid input message.
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
