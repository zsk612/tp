package ui.diet.dietmanager;

import ui.CommonUi;

public class DietManagerUi extends CommonUi {

    public static void printOpening() {
        showUser("You're now in diet manager!");
    }

    public static void printBye() {
        showUser("Exiting diet manager!");
    }

    public static void printHelp() {
        StringBuilder helpMessage = new StringBuilder();

        helpMessage.append(helpFormatter("List", "list",
                "Show all past diet session"));
        helpMessage.append(helpFormatter("New", "new /d [DATE] /t [TAG]",
                "Create a new diet session"));
        helpMessage.append(helpFormatter("Delete", "delete [INDEX_OF_SESSION]",
                "Delete the diet session at the input index"));
        helpMessage.append(helpFormatter("Edit", "edit [INDEX_OF_SESSION]",
                "Edit the diet session at the input index"));
        helpMessage.append(helpFormatter("Clear", "clear",
                "Clear all past diet sessions"));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to main menu"));
        showUser(helpMessage.toString().trim());
    }
}