package diet.dietsession.command;

import diet.dietsession.DietSession;
import diet.dietsession.Food;
import storage.DietSessionStorage;

import java.util.ArrayList;

public interface Command {

    public void execute(String input, ArrayList<Food> foodList, DietSessionStorage storage);

}
