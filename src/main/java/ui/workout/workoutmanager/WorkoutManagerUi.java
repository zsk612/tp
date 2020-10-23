package ui.workout.workoutmanager;

import ui.CommonUi;

public class WorkoutManagerUi extends CommonUi {

    public static void printOpening() {
        System.out.println("Let's manage your workout sessions!");
    }

    public static void printBye() {
        System.out.println("Bye!");
    }

    public static void printStartLoading() {
        System.out.println("Loading history records...");
    }

    public static void printFinishLoading() {
        System.out.println("Loading completed!");
    }

    public static String CLEAR_SUCCESS = "You have cleared all records!";
    public static String CLEAR_ABORTED = "You have aborted the action!";
    public static String DELETE_SUCCESS = "You have deleted that record!";
    public static String EDIT_SUCCESS = "Congratulations! You have finished today's workout!";
    public static String NEW_SUCCESS = "Congratulations! You have finished today's workout!";
    public static String COMMAND_NOT_FOUND = "The command not recognised!";

    public static String MESSAGE_NOT_A_NUMBER = "Index must be a number. Your input is not a number!";
    public static String MESSAGE_INSUFFICIENT_ARGUMENT = "Insufficient arguments are given!";
    public static String MESSAGE_OUT_OF_ARRAY = "The record specified is not found. Please check the index!";


    public static void printStartNewSessionResponse() {
        System.out.println("You have started a new workout session!");
    }

    public static void printTableHeader() {
        System.out.printf("%-7s %-15s %s%n", "Index", "Created on", "Tags");
    }

    public static void commandNotFoundResponse() {
        System.out.println("The command not recognised!");
    }


}
