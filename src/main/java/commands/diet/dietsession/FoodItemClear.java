package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemClear extends Command {

    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for clear command to clear all food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage) {
        if (checkConfirmation()) {
            foodList.clear();
            ui.showToUser("Oops you have cleared all the food items.");
            logger.log(Level.INFO, "Cleared all food in arraylist");
        } else {
            System.out.println("You have aborted clear operation.");
        }
    }

    private boolean checkConfirmation() {
        ui.showToUser("Are you sure you want to clear all records? This action is irrevocable.\n"
                + "\t Key in YES to confirm.");
        String input = ui.getCommand("Diet Menu");
        return input.equals("YES");
    }
}
