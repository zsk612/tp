package ui.workout.workoutsession;

import models.Exercise;
import ui.CommonUi;


public class WorkoutSessionUi extends CommonUi {

    public static String printError() {
        return ("There is an error, please restart the session");
    }

    public static String addFormatError() {
        return ("Wrong format, please enter in the format:\n\t "
                + "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]");
    }

    public static String addFormatNegativeError() {
        return ("Wrong format, please enter in the format:\n\t "
                + "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]\n\t "
                + "Please make sure [NUMBER_OF_REPETITIONS] and [WEIGHT] are numbers greater than zero.");
    }

    public static String saveCorruptedError(String filePath) {
        return (":( Save format in "
                + filePath + " is invalid.\n\t "
                + "File is cleared.");
    }

    public static String emptyListError() {
        return ("List is empty. Please enter something.");
    }

    public static String deleteFormatError() {
        return ("Wrong format, please enter in the format:\n\t delete [INDEX]");
    }

    public static String deleteIndexError() {
        return ("Index does not exist. Please refer to the list.");
    }

    public static String printHelp() {
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
        return (helpMessage.toString().trim());
    }

    public static String emptyInputError() {
        return ("Please enter something.");
    }

    public static String searchInputError() {
        return ("Wrong format, please enter in the format:\n\t search [NAME_OF_MOVE]");
    }

    public static String searchResultsEmpty() {
        return ("No matching result has been found.");
    }

    public static String addExerciseSuccess(Exercise exercise) {
        String toPrint = String.format("Yay! You have added %s to your list.\n\t [Repetitions: %s || Weight: %s]",
                exercise.getDescription(), exercise.getRepetitions(), exercise.getWeight());
        return (toPrint);
    }

    public static String deleteExerciseSuccess(Exercise exercise) {
        String toPrint = String.format("You have deleted %s from your list!\n\t [Repetitions: %s || Weight: %s]",
                exercise.getDescription(), exercise.getRepetitions(), exercise.getWeight());
        return (toPrint);
    }
}
