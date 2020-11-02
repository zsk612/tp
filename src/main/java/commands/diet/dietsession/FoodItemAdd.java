package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.DietSessionParser;
import diet.dietsession.Food;
import exceptions.diet.NegativeCaloriesException;
import exceptions.diet.NoNameException;
import storage.diet.DietStorage;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemAdd extends Command {

    /**
     * Overrides execute for add command to add food items.
     *
     * @param input    user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage  storage for diet session
     * @param index    Integer variable that shows the index of the session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage, Integer index) {
        DietSessionParser parser = new DietSessionParser();

        try {
            assert !input.isEmpty();
            StringBuilder userOutput = new StringBuilder();
            Double calories = parser.processFoodCalories(input);
            Food temp = new Food(parser.processFoodName(input), Math.min(calories, 200000));
            foodList.add(temp);
            if (calories > 200000) {
                userOutput.append("Your calories for this food item seems a little high, "
                        + "so I've set it to 200,000.\n\t ");
            }
            userOutput.append("Yay! You have added " + temp.toString());
            ui.showToUser(userOutput.toString());
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
            logger.log(Level.WARNING, "Put negative calories");
        } catch (NoNameException e) {
            ui.showToUser("Please enter food name!");
            logger.log(Level.WARNING, "no food name");
        }
    }
}
