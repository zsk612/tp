package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static ui.CommonUi.printHelpFormater;

public class FoodItemHelp extends Command {

    /**
     * Overrides execute for help command to display help information for dietSession.
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
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
        logger.log(Level.INFO, "Displayed help in dietSession");
    }
}
