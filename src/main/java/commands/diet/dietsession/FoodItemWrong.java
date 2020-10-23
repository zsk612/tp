package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class FoodItemWrong extends Command {

    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for wrong command.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        ui.showToUser("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Wrong input for dietSession");
    }
}
