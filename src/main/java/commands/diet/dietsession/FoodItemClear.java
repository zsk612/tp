package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class FoodItemClear extends Command {

    private final DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for clear command to clear all food items.
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        if (checkConfirmation()) {
            foodList.clear();
            System.out.println("Oops you have cleared all the food items.");
            logger.log(Level.INFO, "Cleared all food in arraylist");
        } else {
            System.out.println("You have aborted clear operation.");
        }
    }

    private boolean checkConfirmation() {
        System.out.println("\tAre you sure you want to clear all records? This action is irrevocable.");
        System.out.println("\tKey in YES to confirm.");
        String input = ui.getCommand("Diet Menu");
        return  input.equals("YES");
    }
}
