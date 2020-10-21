package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;

import static ui.CommonUi.printHelpFormatter;

public class FoodItemHelp extends Command {
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        printHelpFormatter("List", "list",
                "Show all food items");
        printHelpFormatter("Add", "add food name /c calories",
                "Add a new food item");
        printHelpFormatter("Delete", "delete x",
                "Delete the food item indexed at x");
        printHelpFormatter("Clear", "clear",
                "Clear all food items");
        printHelpFormatter("End", "end",
                "Go back to diet manager menu");
    }
}
