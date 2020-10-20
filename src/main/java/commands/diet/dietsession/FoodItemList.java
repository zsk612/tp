package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;
import commands.Command;
import static logger.SchwarzeneggerLogger.logger;

import java.util.ArrayList;
import java.util.logging.Level;

public class FoodItemList extends Command {

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
