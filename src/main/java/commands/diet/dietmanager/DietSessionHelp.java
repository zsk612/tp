package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.util.logging.Logger;

import static ui.CommonUi.printHelpFormater;

public class DietSessionHelp extends Command {

    @Override
    public void execute(String input, Storage storage, Logger logger) {
        printHelpFormater("List", "list",
                "Show all past sessions");
        printHelpFormater("Meal", "meal /d date /t tag",
                "Create a new meal session");
        printHelpFormater("Delete", "delete x",
                "Delete the record indexed at x");
        printHelpFormater("Edit", "edit x",
                "Edit the record indexed at x");
        printHelpFormater("Clear", "clear",
                "Clear all past results");
        printHelpFormater("End", "end",
                "Go back to main menu");
    }
}
