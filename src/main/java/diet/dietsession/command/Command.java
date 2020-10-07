package diet.dietsession.command;

import diet.dietsession.Food;

import java.util.ArrayList;

public interface Command {

    public void execute(String input, ArrayList<Food> foodList);

}
