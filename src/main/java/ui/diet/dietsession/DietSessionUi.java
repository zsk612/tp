package ui.diet.dietsession;

import java.util.Scanner;

import ui.CommonUi;

public class DietSessionUi extends CommonUi {

    private static CommonUi printer = new CommonUi();

    public static void printHelp() {
        StringBuilder helpMessage = new StringBuilder();

        helpMessage.append(helpFormatter("Add", "add [FOOD_NAME] /c [CALORIES]",
                "Add a new food item"));
        helpMessage.append(helpFormatter("List", "list",
                "Show all food items"));
        helpMessage.append(helpFormatter("Delete", "delete [INDEX_OF_FOOD]",
                "Delete the food item at the input index"));
        helpMessage.append(helpFormatter("Clear", "clear",
                "Clear all food items"));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to the diet manager menu."));
        printer.showToUser(helpMessage.toString().trim());
    }

    public void printOpening() {
        showToUser("Starting Diet Session!");
    }

    public void printExit() {
        showToUser("Exiting Diet Session!");
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
