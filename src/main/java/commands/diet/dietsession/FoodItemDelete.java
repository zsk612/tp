package commands.diet.dietsession;

import diet.dietsession.Food;
import storage.diet.Storage;
import commands.Command;

import java.util.ArrayList;
import java.util.logging.Logger;

public class FoodItemDelete extends Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage, Logger logger) {
        try {
            assert !input.isEmpty();
            int index = Integer.parseInt(input);
            Food temp = foodList.get(index - 1);
            System.out.println("Oh no! You have deleted " + temp.toString());
            foodList.remove(temp);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
        }
    }
}
