package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.DietStorage;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemClear extends Command {

    /**
     * Overrides execute for clear command to clear all food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     * @param index Integer variable that shows the index of the session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage, Integer index) {
        String prompt;
        if (index <= 0) {
            prompt = "Diet Menu > New Diet Session";
        } else {
            prompt = "Diet Menu > Diet Session " + index;
        }
        if (ui.checkConfirmation(prompt, "clear all records")) {
            foodList.clear();
            ui.showToUser("Oops you have cleared all the food items.");
            logger.log(Level.INFO, "Cleared all food in arraylist");
        } else {
            System.out.println("You have aborted clear operation.");
        }
    }
}
