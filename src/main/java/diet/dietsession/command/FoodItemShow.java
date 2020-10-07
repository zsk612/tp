package diet.dietsession.command;

import diet.dietsession.Food;

import java.util.ArrayList;

public class FoodItemShow implements Command {

    @Override
    public void execute(String input, ArrayList<Food> foodList) {
        int numOfFood = 1;
        for(Food item: foodList) {
            System.out.println(numOfFood + ". " +item.toString());
            numOfFood++;
        }
    }


}
