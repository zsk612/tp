package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class FoodItemClear extends Command {

    /**
     * Overrides execute for clear command to clear all food items.
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        foodList.clear();
        System.out.println("Oops you have cleared all the food items.");
        logger.log(Level.INFO, "Cleared all food in arraylist");
    }


}
