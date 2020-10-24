package commands.diet.dietmanager;

import commands.Command;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Level;

public class DietSessionWrong extends Command {

    DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for wrong command.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {
        ui.showToUser("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
    }
}
