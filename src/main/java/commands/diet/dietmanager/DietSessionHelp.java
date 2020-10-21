package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import static ui.CommonUi.printHelpFormatter;

public class DietSessionHelp extends Command {
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
    }
}
