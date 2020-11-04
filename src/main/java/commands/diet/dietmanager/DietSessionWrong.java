package commands.diet.dietmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.InvalidCommandWordException;
import storage.diet.DietStorage;

public class DietSessionWrong extends Command {

    /**
     * Overrides execute for wrong command.
     *  @param input user input for command
     * @param storage storage for diet manager
     * @return
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
