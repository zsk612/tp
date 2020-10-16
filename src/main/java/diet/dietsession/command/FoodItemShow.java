package diet.dietsession.command;

import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemShow implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        try {
            System.out.println("Here is your food list: ");
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println((i + 1) + ". " + foodList.get(i).toString());
            }
            logger.log(Level.INFO, "Listed all foods in Diet Session");
        } catch (NullPointerException e) {
            System.out.println("Sorry, there is nothing in your food list.");
        }
    }


}
