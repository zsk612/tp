package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemHelp extends Command {

    /**
     * Overrides execute for help command to display help information for dietSession.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage) {

        DietSessionUi.printHelp();
        logger.log(Level.INFO, "Displayed help in dietSession");
    }
}
