package diet.dietsession.command;

import diet.dietsession.Food;

import java.util.ArrayList;

public class FoodItemDelete implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList) {
        int index = Integer.parseInt(input);
        foodList.remove(index - 1);
    }
}
