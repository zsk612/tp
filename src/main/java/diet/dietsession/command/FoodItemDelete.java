package diet.dietsession.command;

import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;

public class FoodItemDelete implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        try {
            foodList.remove(Integer.parseInt(input) - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
        }
    }
}
