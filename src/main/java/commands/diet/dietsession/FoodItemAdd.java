package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.DietSession;
import diet.dietsession.DietSessionParser;
import diet.dietsession.Food;
import logger.SchwarzeneggerLogger;
import storage.diet.Storage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class FoodItemAdd extends Command {

    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for add command to add food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        DietSessionParser parser = new DietSessionParser();
        SchwarzeneggerLogger.initSchwarzeneggerLogger();
        try {
            assert !input.isEmpty();
            Food temp = new Food(parser.processFoodName(input), parser.processFoodCalories(input));
            foodList.add(temp);
            ui.showToUser("Yay! You have added " + temp.toString());
            logger.log(Level.INFO, "Added food to arraylist");
        } catch (IndexOutOfBoundsException e) {
            ui.showToUser("Please specify food info.");
            logger.log(Level.WARNING, "Did not put food name or calories");
        } catch (NumberFormatException e) {
            ui.showToUser("Please input a number for calories.");
            logger.log(Level.WARNING, "Put calories in a wrong format");
        }
    }
}
