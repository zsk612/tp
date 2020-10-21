package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionHelp extends Command {

    /**
     * Overrides execute for help command to display help information.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {

        DietManagerUi.printHelp();
        logger.log(Level.INFO, "Displayed help in dietManager");
    }
}
