package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.DietSessionParser;
import diet.dietsession.Food;
import logger.SchwarzeneggerLogger;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class FoodItemAdd extends Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        DietSessionParser parser = new DietSessionParser();
        SchwarzeneggerLogger.initSchwarzeneggerLogger();
        try {
            assert !input.isEmpty();
            Food temp = new Food(parser.processFoodName(input), parser.processFoodCalories(input));
            foodList.add(temp);
            System.out.println("Yay! You have added " + temp.toString());
            logger.log(Level.INFO, "Added food to arraylist");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please specify food info.");
        } catch (NumberFormatException e) {
            System.out.println("Please input a number for calories.");
        }
    }
}
