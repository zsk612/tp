package diet.dietsession.command;

import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Command {

    Logger logger = Logger.getLogger("java.diet.dietsession.command");

    public void execute(String input, ArrayList<Food> foodList, Storage storage);

}
