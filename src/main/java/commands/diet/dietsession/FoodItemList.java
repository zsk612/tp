package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import logger.SchwarzeneggerLogger;
import storage.diet.Storage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodItemList extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for list command to list food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        try {
            ui.showToUser("Here is your food list: ");
            int i;
            for (i = 0; i < foodList.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + foodList.get(i).toString());
            }
            logger.log(Level.INFO, "Listed all foods in Diet Session");
            if (i == 0) {
                ui.showToUser("Sorry, there is nothing in your food list.");
            }
        } catch (NullPointerException e) {
            ui.showToUser("Sorry, there is nothing in your food list.");
            logger.log(Level.WARNING, "No item in food list");
        }
    }
}
