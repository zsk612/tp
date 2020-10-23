package commands.diet.dietmanager;

import commands.Command;
import logger.SchwarzeneggerLogger;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DietSessionWrong extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for wrong command.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        ui.showToUser("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
    }
}
