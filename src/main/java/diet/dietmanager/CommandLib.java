package diet.dietmanager;

<<<<<<< HEAD
import diet.dietmanager.command.Command;
import diet.dietmanager.command.DietSessionCreate;
import diet.dietmanager.command.DietSessionList;
import diet.dietmanager.command.DietSessionLoad;
import diet.dietmanager.command.DietSessionWrong;
=======
import diet.dietmanager.command.*;
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("meal", new DietSessionCreate());
        this.library.put("load", new DietSessionLoad());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return new DietSessionWrong();
        }
    }
}
