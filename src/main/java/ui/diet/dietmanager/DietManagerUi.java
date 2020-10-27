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
        helpMessage.append(helpFormatter("Search",
                "search </s [STARTING_DATE]> </e [END_DATE]> </t [TAG]>",
                "Search the diet session in between starting and end dates with tags in its name"));
        helpMessage.append(helpFormatter("Clear", "clear",
                "Clear all past diet sessions"));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to Main Menu"));
        showUser(helpMessage.toString().trim());
    }
}
