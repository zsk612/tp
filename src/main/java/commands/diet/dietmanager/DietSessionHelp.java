package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static ui.CommonUi.printHelpFormater;

public class DietSessionHelp extends Command {

    /**
     * Overrides execute for help command to display help information.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        printHelpFormatter("List", "list",
                "Show all past diet session");
        printHelpFormatter("Meal", "meal /d date /t tag",
                "Create a new diet session");
        printHelpFormatter("Delete", "delete x",
                "Delete the diet session indexed at x");
        printHelpFormatter("Edit", "edit x",
                "Edit the diet session indexed at x");
        printHelpFormatter("Clear", "clear",
                "Clear all past diet sessions");
        printHelpFormatter("End", "end",
                "Go back to main menu");
        logger.log(Level.INFO, "Displayed help in dietManager");
    }
}
