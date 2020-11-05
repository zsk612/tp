package logic.commands.diet.dietmanager;

import logic.commands.Command;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Level;

public class DietSessionHelp extends Command {

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
