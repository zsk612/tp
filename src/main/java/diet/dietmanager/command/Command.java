package diet.dietmanager.command;

import storage.diet.Storage;

public interface Command {
    public void execute(String input, Storage storage);
}
