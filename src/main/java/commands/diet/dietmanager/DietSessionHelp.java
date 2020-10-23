package commands.diet.dietmanager;

import commands.Command;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DietSessionHelp extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    /**
     * Overrides execute for help command to display help information.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {

        DietManagerUi.printHelp();
        logger.log(Level.INFO, "Displayed help in dietManager");
    }
}
