package diet.dietsession;

import java.util.ArrayList;
import java.util.Scanner;

public class DietSessionParser {
    public void dietSessionProcessCommand(String input, ArrayList<Food> list){
        String[] inputSplit = input.split(" ", 2);
        String command = inputSplit[0];
        String parameters = inputSplit[1];
        switch (command) {
        case "add":
            String[] description = parameters.split("/c", 2);
            Food temp = new Food(description[0], Double.parseDouble(description[1]));
            list.add(temp);
            break;
        case "delete":
            int index = Integer.parseInt(parameters);
            list.remove(index - 1);
            break;
        case "end":
            break;
        default:
            System.out.println("Sorry! You have entered an invalid command!");
            break;
        }
    }
}
