package diet.dietsession.command;

import diet.dietsession.Food;
import storage.DietSessionStorage;

import java.util.ArrayList;

public class FoodItemWrong implements Command {
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietSessionStorage storage) {
        System.out.println("Sorry, I do not get what you are saying.");
    }
}
