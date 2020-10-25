package commands.diet.dietmanager;

import commands.Command;
import exceptions.InvalidCommandWordException;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Level;

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
