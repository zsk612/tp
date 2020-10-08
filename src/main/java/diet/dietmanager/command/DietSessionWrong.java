package diet.dietmanager.command;

import storage.DietManagerStorage;

public class DietSessionWrong implements Command {
    @Override
    public void execute(String input, DietManagerStorage storage) {
        System.out.println("Sorry, I do not get what you are saying.");
    }
}
