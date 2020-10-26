package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemList extends Command {

    /**
     * Overrides execute for list command to list food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage) {
        try {
            double totalCalories = 0;
            StringBuilder listResult = new StringBuilder();
            if (foodList.size() > 0) {
                int i;
                listResult.append("Here is your food list: \n\t ");
                for (i = 0; i < foodList.size(); i++) {
                    listResult.append(" " + (i + 1) + ". " + foodList.get(i).toString() + "\n\t");
                    totalCalories += foodList.get(i).getCalories();
                }
                String totalMealCalories = " Your total calories for this meal is " + totalCalories + ".";
                listResult.append(totalMealCalories);
                ui.showToUser(listResult.toString().trim());

                logger.log(Level.INFO, "Listed all foods in Diet Session");
            } else {
                listResult.append("Sorry, there is nothing in your food list.");
                ui.showToUser(listResult.toString().trim());
            }
        } catch (NullPointerException e) {
            ui.showToUser("Sorry, there is nothing in your food list.");
            logger.log(Level.WARNING, "No item in food list");
        }
    }
}
