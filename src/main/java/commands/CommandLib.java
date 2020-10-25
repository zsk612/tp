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
import commands.diet.dietsession.FoodItemSearch;
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

import static seedu.duke.Constant.COMMAND_WORD_ADD;
import static seedu.duke.Constant.COMMAND_WORD_CLEAR;
import static seedu.duke.Constant.COMMAND_WORD_DELETE;
import static seedu.duke.Constant.COMMAND_WORD_DIET;
import static seedu.duke.Constant.COMMAND_WORD_EDIT;
import static seedu.duke.Constant.COMMAND_WORD_END;
import static seedu.duke.Constant.COMMAND_WORD_HELP;
import static seedu.duke.Constant.COMMAND_WORD_LIST;
import static seedu.duke.Constant.COMMAND_WORD_MEAL;
import static seedu.duke.Constant.COMMAND_WORD_NEW;
import static seedu.duke.Constant.COMMAND_WORD_PROFILE;
import static seedu.duke.Constant.COMMAND_WORD_SEARCH;
import static seedu.duke.Constant.COMMAND_WORD_VIEW;
import static seedu.duke.Constant.COMMAND_WORD_WORKOUT;
import static seedu.duke.Constant.COMMAND_WORD_WRONG;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    /**
     * Initializes the commandLib with main menu's commands.
     */
    public void initMainMenu() {
        library.put(COMMAND_WORD_WRONG, new Wrong());
        library.put(COMMAND_WORD_HELP, new Help());
        library.put(COMMAND_WORD_DIET, new ToDiet());
        library.put(COMMAND_WORD_PROFILE, new ToProfile());
        library.put(COMMAND_WORD_WORKOUT, new ToWorkout());
    }

    /**
     * Initializes the commandLib with profile menu's commands.
     */
    public void initProfileSessionCL() {
        library.put(COMMAND_WORD_HELP, new ProfileHelp());
        library.put(COMMAND_WORD_ADD, new ProfileAdd());
        library.put(COMMAND_WORD_DELETE, new ProfileDelete());
        library.put(COMMAND_WORD_VIEW, new ProfileView());
        library.put(COMMAND_WORD_EDIT, new ProfileEdit());
        library.put(COMMAND_WORD_END, new ProfileEnd());
        library.put(COMMAND_WORD_WRONG, new ProfileWrong());
    }


    /**
     * Initializes the commandLib with workout menu's commands.
     */
    public void initWorkoutManagerCL() {
        library.put(COMMAND_WORD_LIST, new ListWS());
        library.put(COMMAND_WORD_NEW, new NewWS());
        library.put(COMMAND_WORD_DELETE, new DeleteWS());
        library.put(COMMAND_WORD_END, new ByeWS());
        library.put(COMMAND_WORD_EDIT, new EditWS());
        library.put(COMMAND_WORD_CLEAR, new ClearWS());
        library.put(COMMAND_WORD_HELP, new HelpWS());
        library.put(COMMAND_WORD_WRONG, new WrongWS());
        library.put(COMMAND_WORD_SEARCH, new SearchWS());
    }

    /**
     * Initialize the commandLib with workout session's commands.
     */
    public void initWorkoutSessionCL() {
        library.put(COMMAND_WORD_ADD, new WorkoutSessionAdd());
        library.put(COMMAND_WORD_DELETE, new WorkoutSessionDelete());
        library.put(COMMAND_WORD_LIST, new WorkoutSessionList());
        library.put(COMMAND_WORD_END, new WorkoutSessionEnd());
        library.put(COMMAND_WORD_HELP, new WorkoutSessionHelp());
        library.put(COMMAND_WORD_SEARCH, new WorkoutSessionSearch());
        library.put(COMMAND_WORD_WRONG, new WorkoutSessionWrong());
    }

    /**
     * Initialize the commandLib with diet manager's commands.
     */
    public void initDietManagerCL() {
        library.put(COMMAND_WORD_LIST, new DietSessionList());
        library.put(COMMAND_WORD_MEAL, new DietSessionCreate());
        library.put(COMMAND_WORD_HELP, new DietSessionHelp());
        library.put(COMMAND_WORD_CLEAR, new DietSessionClear());
        library.put(COMMAND_WORD_SEARCH, new DietSessionSearch());
        library.put(COMMAND_WORD_EDIT, new DietSessionEdit());
        library.put(COMMAND_WORD_DELETE, new DietSessionDelete());
        library.put(COMMAND_WORD_WRONG, new DietSessionWrong());
    }

    /**
     * Initialize the commandLib with diet session's commands.
     */
    public void initDietSessionCL() {
        library.put(COMMAND_WORD_ADD, new FoodItemAdd());
        library.put(COMMAND_WORD_DELETE, new FoodItemDelete());
        library.put(COMMAND_WORD_HELP, new FoodItemHelp());
        library.put(COMMAND_WORD_CLEAR, new FoodItemClear());
        library.put(COMMAND_WORD_SEARCH, new FoodItemSearch());
        library.put(COMMAND_WORD_LIST, new FoodItemList());
        library.put(COMMAND_WORD_WRONG, new FoodItemWrong());
    }

    /**
     * Gets specific Command object based on command keyword.
     *
     * @param keyword Keyword specifying type of command.
     * @return Command object.
     */
    public Command getCommand(String keyword) {
        if (library.containsKey(keyword.toLowerCase())) {
            return library.get(keyword.toLowerCase());
        } else {
            return library.get(COMMAND_WORD_WRONG);
        }
    }
}
