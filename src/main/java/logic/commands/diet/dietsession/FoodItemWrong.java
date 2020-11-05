package logic.commands.diet.dietsession;

import logic.commands.Command;
import diet.dietsession.Food;
import exceptions.InvalidCommandWordException;
import storage.diet.DietStorage;

import java.util.ArrayList;

public class FoodItemWrong extends Command {

    /**
     * Overrides execute for wrong command.
     *
     * @param input user input for command.
     * @param foodList arraylist that stored all the food items.
     * @param storage storage for diet session.
     * @param index Integer variable that shows the index of the session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList,
                        DietStorage storage, Integer index) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
