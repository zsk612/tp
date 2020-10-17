package commands.diet.dietmanager;

import commands.diet.dietmanager.command.Command;
import commands.diet.dietmanager.command.DietSessionCreate;
import commands.diet.dietmanager.command.DietSessionDelete;
import commands.diet.dietmanager.command.DietSessionList;
import commands.diet.dietmanager.command.DietSessionLoad;
import commands.diet.dietmanager.command.DietSessionWrong;
import commands.diet.dietsession.command.FoodItemAdd;
import commands.diet.dietsession.command.FoodItemDelete;
import commands.diet.dietsession.command.FoodItemShow;

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
        this.library.put("delete", new DietSessionDelete());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return new DietSessionWrong();
        }
    }
}
