package commands;

import diet.dietsession.Food;
import storage.diet.Storage;

import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class Command {

    protected static final Logger logger = Logger.getLogger("java.workout.command");

    public void execute(String[] args) {
        return;
    }

    public void execute(String input, Storage storage) {
        return;
    }

    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        return;
    }
}
