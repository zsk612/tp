package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import exceptions.InvalidCommandWordException;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemWrong extends Command {

    /**
     * Overrides execute for wrong command.
     *
     * @param input user input for command.
     * @param foodList arraylist that stored all the food items.
     * @param storage storage for diet session.
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList,
                        DietStorage storage) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
