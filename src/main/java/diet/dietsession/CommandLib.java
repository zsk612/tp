package diet.dietsession;

import diet.dietsession.command.Command;
import diet.dietsession.command.FoodItemAdd;
import diet.dietsession.command.FoodItemDelete;
import diet.dietsession.command.FoodItemShow;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("add", new FoodItemAdd());
        this.library.put("delete", new FoodItemDelete());
        this.library.put("show", new FoodItemShow());
        System.out.println("init cl");
    }

    public Command get(String keyword) {
        return library.get(keyword);
    }
}
