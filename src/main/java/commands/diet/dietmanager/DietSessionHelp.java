package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import static ui.CommonUi.printHelpFormater;

public class DietSessionHelp extends Command {
    public void execute(String input, Storage storage) {
        printHelpFormater("List", "list",
                "Show all past diet session");
        printHelpFormater("Meal", "meal /d date /t tag",
                "Create a new diet session");
        printHelpFormater("Delete", "delete x",
                "Delete the diet session indexed at x");
        printHelpFormater("Edit", "edit x",
                "Edit the diet session indexed at x");
        printHelpFormater("Clear", "clear",
                "Clear all past diet sessions");
        printHelpFormater("End", "end",
                "Go back to main menu");
    }
}
