package logic.commands.diet.dietmanager;

import logic.commands.Command;
import exceptions.InvalidCommandWordException;
import storage.diet.DietStorage;

public class DietSessionWrong extends Command {

    /**
     * Overrides execute for wrong command.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
