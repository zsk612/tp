package diet.dietmanager.command;

import storage.DietManagerStorage;

public interface Command {
    public void execute(String input, DietManagerStorage storage);
}
