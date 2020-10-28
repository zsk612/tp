package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.DietSessionParser;
import diet.dietsession.Food;
import exceptions.diet.NegativeCaloriesException;
import exceptions.profile.InvalidCaloriesException;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemAdd extends Command {

    /**
     * Overrides execute for add command to add food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     * @param index Integer variable that shows the index of the session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage, Integer index) {
        DietSessionParser parser = new DietSessionParser();

        try {
            assert !input.isEmpty();
            Food temp = new Food(parser.processFoodName(input), parser.processFoodCalories(input));
            foodList.add(temp);
            ui.showToUser("Yay! You have added " + temp.toString());
            logger.log(Level.INFO, "Added food to arraylist");
        } catch (IndexOutOfBoundsException e) {
            ui.showToUser("Wrong format, please enter in the format:\n\t "
                    + "add [FOOD_NAME] /c [CALORIES]");
            logger.log(Level.WARNING, "Did not put food name or calories");
        } catch (NumberFormatException e) {
            ui.showToUser("Please input a number for calories.");
            logger.log(Level.WARNING, "Put calories in a wrong format");
        } catch (NegativeCaloriesException e) {
            ui.showToUser("Please enter a positive number for calories!");
        }
    }
}
