package commands;

import commands.diet.dietmanager.DietSessionCreate;
import commands.diet.dietmanager.DietSessionDelete;
import commands.diet.dietmanager.DietSessionList;
import commands.diet.dietmanager.DietSessionLoad;
import commands.diet.dietmanager.DietSessionWrong;
import commands.diet.dietsession.FoodItemAdd;
import commands.diet.dietsession.FoodItemDelete;
import commands.diet.dietsession.FoodItemShow;
import commands.diet.dietsession.FoodItemWrong;
import commands.workout.workoutmanager.ByeWS;
import commands.workout.workoutmanager.ClearWS;
import commands.workout.workoutmanager.DeleteWS;
import commands.workout.workoutmanager.EditWS;
import commands.workout.workoutmanager.HelpWS;
import commands.workout.workoutmanager.ListWS;
import commands.workout.workoutmanager.NewWS;
import commands.workout.workoutmanager.SearchWS;
import commands.workout.workoutmanager.WrongWS;
import commands.workout.workoutsession.WorkoutSessionAdd;
import commands.workout.workoutsession.WorkoutSessionEnd;
import commands.workout.workoutsession.WorkoutSessionDelete;
import commands.workout.workoutsession.WorkoutSessionList;
import commands.workout.workoutsession.WorkoutSessionWrong;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initWorkoutManagerCL() {
        library.put("list", new ListWS());
        library.put("new", new NewWS());
        library.put("delete", new DeleteWS());
        library.put("end", new ByeWS());
        library.put("edit", new EditWS());
        library.put("clear", new ClearWS());
        library.put("help", new HelpWS());
        library.put("wrong", new WrongWS());
        library.put("search", new SearchWS());
    }

    public void initWorkoutSessionCL() {
        library.put("add", new WorkoutSessionAdd());
        library.put("delete", new WorkoutSessionDelete());
        library.put("list", new WorkoutSessionList());
        library.put("end", new WorkoutSessionEnd());
        library.put("wrong", new WorkoutSessionWrong());
    }

    public void initDietManagerCL() {
        library.put("list", new DietSessionList());
        library.put("meal", new DietSessionCreate());
        library.put("load", new DietSessionLoad());
        library.put("delete", new DietSessionDelete());
        library.put("wrong", new DietSessionWrong());
    }

    public void initDietSessionCL() {
        library.put("add", new FoodItemAdd());
        library.put("delete", new FoodItemDelete());
        library.put("show", new FoodItemShow());
        library.put("wrong", new FoodItemWrong());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return library.get("wrong");
        }
    }
}
