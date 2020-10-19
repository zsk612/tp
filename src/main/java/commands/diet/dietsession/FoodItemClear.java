package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Logger;

public class FoodItemClear extends Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList, Storage storage, Logger logger) {

        foodList.clear();
        System.out.println("Oops, you have cleared all the recorded food items!");
    }
}
