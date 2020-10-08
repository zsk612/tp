package storage;

import diet.dietsession.DietSession;
import diet.dietsession.Food;

import java.util.ArrayList;
import java.util.List;

public class DietSessionStorage {

    public void list(String input, ArrayList<Food> foodList) {
        if (foodList.isEmpty()) {
            System.out.println("There is nothing in your list.");
        } else {
            int numOfFood = 1;
            for(Food item: foodList) {
                System.out.println(numOfFood + ". " +item.toString());
                numOfFood++;
            }
        }
    }

    public void add(String input, ArrayList<Food> foodList) {
        try {
            String[] description = input.split("/c", 2);
            Food temp = new Food(description[0], Double.parseDouble(description[1]));
            foodList.add(temp);
            System.out.println("Got it! You have added " + temp.toString());
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Please specify your food info.");
        }

    }

    public void delete(String input, ArrayList<Food> foodList) {
        try {
            int index = Integer.parseInt(input);
            Food temp = foodList.get(index - 1);
            System.out.println("Oh no! You have deleted " + temp.toString());
            foodList.remove(temp);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Sorry, the index is not found.");
        }

    }
}
