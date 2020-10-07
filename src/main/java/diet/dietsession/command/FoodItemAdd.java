package diet.dietsession.command;

import diet.dietsession.Food;

import java.util.ArrayList;

public class FoodItemAdd implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList) {
        String[] description = input.split("/c", 2);
        Food temp = new Food(description[0], Double.parseDouble(description[1]));
        foodList.add(temp);
    }
}
