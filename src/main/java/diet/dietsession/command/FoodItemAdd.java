package diet.dietsession.command;

import diet.dietsession.Food;
import diet.dietsession.DietSessionParser;
import storage.diet.Storage;


import java.util.ArrayList;

public class FoodItemAdd implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        DietSessionParser parser = new DietSessionParser();
        Food temp = new Food(parser.processFoodName(input), parser.processFoodCalories(input));
        foodList.add(temp);
    }
}
