package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import logger.SchwarzeneggerLogger;
import storage.diet.Storage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodItemDelete extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for delete command to delete food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        try {
            assert !input.isEmpty();
            int index = Integer.parseInt(input);
            Food temp = foodList.get(index - 1);
            ui.showToUser("You have deleted " + temp.toString() + " from your list!");
            foodList.remove(temp);
            logger.log(Level.INFO, "Removed food from arraylist");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            ui.showToUser("Sorry! It seems like you've entered an invalid number or input!");
            logger.log(Level.WARNING, "Did not input correct index");
        }
    }
}
