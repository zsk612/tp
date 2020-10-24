package commands;

import commands.diet.dietmanager.DietSessionClear;
import commands.diet.dietmanager.DietSessionCreate;
import commands.diet.dietmanager.DietSessionDelete;
import commands.diet.dietmanager.DietSessionEdit;
import commands.diet.dietmanager.DietSessionHelp;
import commands.diet.dietmanager.DietSessionList;
import commands.diet.dietmanager.DietSessionSearch;
import commands.diet.dietmanager.DietSessionWrong;
import commands.diet.dietsession.FoodItemAdd;
import commands.diet.dietsession.FoodItemClear;
import commands.diet.dietsession.FoodItemDelete;
import commands.diet.dietsession.FoodItemHelp;
import commands.diet.dietsession.FoodItemList;
import commands.diet.dietsession.FoodItemWrong;
import commands.main.Help;
import commands.main.ToDiet;
import commands.main.ToProfile;
import commands.main.ToWorkout;
import commands.main.Wrong;
import commands.profile.ProfileAdd;
import commands.profile.ProfileDelete;
import commands.profile.ProfileEdit;
import commands.profile.ProfileEnd;
import commands.profile.ProfileHelp;
import commands.profile.ProfileView;
import commands.profile.ProfileWrong;
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
import commands.workout.workoutsession.WorkoutSessionDelete;
import commands.workout.workoutsession.WorkoutSessionEnd;
import commands.workout.workoutsession.WorkoutSessionHelp;
import commands.workout.workoutsession.WorkoutSessionList;
import commands.workout.workoutsession.WorkoutSessionSearch;
import commands.workout.workoutsession.WorkoutSessionWrong;

import java.util.Hashtable;

import static profile.Constants.COMMAND_WORD_ADD;
import static profile.Constants.COMMAND_WORD_DELETE;
import static profile.Constants.COMMAND_WORD_EDIT;
import static profile.Constants.COMMAND_WORD_END;
import static profile.Constants.COMMAND_WORD_HELP;
import static profile.Constants.COMMAND_WORD_VIEW;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initMainMenu() {
        library.put("wrong", new Wrong());
        library.put(COMMAND_WORD_HELP, new Help());
        library.put("diet", new ToDiet());
        library.put("profile", new ToProfile());
        library.put("workout", new ToWorkout());
    }

    public void initProfileSessionCL() {
        library.put(COMMAND_WORD_HELP, new ProfileHelp());
        library.put(COMMAND_WORD_ADD, new ProfileAdd());
        library.put(COMMAND_WORD_DELETE, new ProfileDelete());
        library.put(COMMAND_WORD_VIEW, new ProfileView());
        library.put(COMMAND_WORD_EDIT, new ProfileEdit());
        library.put(COMMAND_WORD_END, new ProfileEnd());
        library.put("wrong", new ProfileWrong());
    }

    public void initWorkoutManagerCL() {
        library.put("list", new ListWS());
        library.put("new", new NewWS());
        library.put(COMMAND_WORD_DELETE, new DeleteWS());
        library.put(COMMAND_WORD_END, new ByeWS());
        library.put(COMMAND_WORD_EDIT, new EditWS());
        library.put("clear", new ClearWS());
        library.put(COMMAND_WORD_HELP, new HelpWS());
        library.put("wrong", new WrongWS());
        library.put("search", new SearchWS());
    }

    public void initWorkoutSessionCL() {
        library.put(COMMAND_WORD_ADD, new WorkoutSessionAdd());
        library.put(COMMAND_WORD_DELETE, new WorkoutSessionDelete());
        library.put("list", new WorkoutSessionList());
        library.put("end", new WorkoutSessionEnd());
        library.put(COMMAND_WORD_HELP, new WorkoutSessionHelp());
        library.put("search", new WorkoutSessionSearch());
        library.put("wrong", new WorkoutSessionWrong());
    }

    public void initDietManagerCL() {
        library.put("list", new DietSessionList());
        library.put("meal", new DietSessionCreate());
        library.put(COMMAND_WORD_HELP, new DietSessionHelp());
        library.put("clear", new DietSessionClear());
        library.put("search", new DietSessionSearch());
        library.put(COMMAND_WORD_EDIT, new DietSessionEdit());
        library.put(COMMAND_WORD_DELETE, new DietSessionDelete());
        library.put("wrong", new DietSessionWrong());
    }

    public void initDietSessionCL() {
        library.put(COMMAND_WORD_ADD, new FoodItemAdd());
        library.put(COMMAND_WORD_DELETE, new FoodItemDelete());
        library.put(COMMAND_WORD_HELP, new FoodItemHelp());
        library.put("clear", new FoodItemClear());
        library.put("search", new FoodItemClear());
        library.put("list", new FoodItemList());
        library.put("wrong", new FoodItemWrong());
    }

    public Command getCommand(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return library.get("wrong");
        }
    }
}
