package diet.dietsession;

import diet.dietsession.command.Command;
import diet.dietsession.command.FoodItemAdd;
import diet.dietsession.command.FoodItemDelete;
import diet.dietsession.command.FoodItemShow;
import diet.dietsession.command.FoodItemWrong;

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
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return new FoodItemWrong();
        }
    }
}
