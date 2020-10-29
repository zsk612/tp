package ui.workout.workoutsession;

import models.Exercise;
import ui.CommonUi;


public class WorkoutSessionUi extends CommonUi {

    public static void printError() {
        showUser("There is an error, please restart the session");
    }

    public static void addFormatError() {
        showUser("Wrong format, please enter in the format:\n\t "
                + "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]");
    }

    public static void addFormatNegativeError() {
        showUser("Wrong format, please enter in the format:\n\t "
                + "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]\n\t "
                + "Please make sure [NUMBER_OF_REPETITIONS] and [WEIGHT] are numbers greater than zero.");
    }

    public static void saveCorruptedError(String filePath) {
        showUser(":( Save format in "
                + filePath + " is invalid.\n\t "
                + "File is cleared.");
    }

    public static void emptyListError() {
        showUser("List is empty. Please enter something.");
    }

    public static void deleteFormatError() {
        showUser("Wrong format, please enter in the format:\n\t delete [MOVE_ID]");
    }

    public static void deleteIndexError() {
        showUser("Index does not exist. Please refer to the list.");
    }

    public static void printHelp() {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter("Add", "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]",
                "Add a new move."));
        helpMessage.append(helpFormatter("List", "list",
                "Show all moves in this current session."));
        helpMessage.append(helpFormatter("Delete", "delete [INDEX]",
                "Delete a move according to the index in the list."));
        helpMessage.append(helpFormatter("Search", "search [NAME_OF_MOVE]",
                "Show a list of moves that match the entered keyword."));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to the Workout Menu."));
        showUser(helpMessage.toString().trim());
    }

    public static void emptyInputError() {
        showUser("Please enter something.");
    }

    public static void searchInputError() {
        showUser("Wrong format, please enter in the format:\n\t search [NAME_OF_MOVE]");
    }

    public static void searchResultsEmpty() {
        showUser("No matching result has been found.");
    }

    public static void addExerciseSuccess(Exercise exercise) {
        String toPrint = String.format("Yay! You have added %s to your list.\n\t [Repetitions: %s || Weight: %s]",
                exercise.getDescription(), exercise.getRepetitions(), exercise.getWeight());
        showUser(toPrint);
    }

    public static void deleteExerciseSuccess(Exercise exercise) {
        String toPrint = String.format("You have deleted %s from your list!\n\t [Repetitions: %s || Weight: %s]",
                exercise.getDescription(), exercise.getRepetitions(), exercise.getWeight());
        showUser(toPrint);
    }
}
