package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;

public class FoodItemClear extends Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        foodList.clear();
        System.out.println("Oops you have cleared all the food items.");
    }


}
