package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class FoodItemDelete extends Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        try {
            assert !input.isEmpty();
            int index = Integer.parseInt(input);
            Food temp = foodList.get(index - 1);
            System.out.println("You have deleted " + temp.toString() + " from your list!");
            foodList.remove(temp);
            logger.log(Level.INFO, "Removed food from arraylist");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
        }
    }
}
