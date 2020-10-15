package diet.dietmanager.command;

import storage.diet.Storage;
<<<<<<< HEAD

public interface Command {
=======
import java.util.logging.Logger;

public interface Command {
    Logger logger = Logger.getLogger("java.diet.dietmanager.command");
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b
    public void execute(String input, Storage storage);
}
