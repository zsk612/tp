package ui.diet.dietsession;

import java.util.Scanner;

import ui.CommonUi;

public class DietSessionUi extends CommonUi {

    private static CommonUi printer = new CommonUi();

    public static void printHelp() {
        StringBuilder helpMessage = new StringBuilder();

        helpMessage.append(helpFormatter("Add", "add food name /c calories",
                "Add a new food item"));
        helpMessage.append(helpFormatter("List", "list",
                "Show all food items"));
        helpMessage.append(helpFormatter("Delete", "delete x",
                "Delete the food item indexed at x"));
        helpMessage.append(helpFormatter("Clear", "clear",
                "Clear all food items"));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to the diet manager menu."));
        printer.showToUser(helpMessage.toString().trim());
    }

    public void printOpening() {
        System.out.println("Starting Diet Session!");
    }

    public void printExit() {
        System.out.println("you have exited Diet Session.");
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
