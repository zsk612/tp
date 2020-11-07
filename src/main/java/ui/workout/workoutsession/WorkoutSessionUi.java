package ui.workout.workoutsession;

import models.Exercise;
import ui.CommonUi;


public class WorkoutSessionUi extends CommonUi {
    public static final String PRINT_ERROR = "File not found, re-creating file.";
    public static final String ADD_FORMAT_ERROR = "Wrong format, please enter in the format:\n\t "
            + "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]";
    public static final String ADD_FORMAT_NEGATIVE_ERROR = "Wrong format, please enter in the format:\n\t "
            + "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]\n\t "
            + "Please make sure [NUMBER_OF_REPETITIONS] and [WEIGHT] are non negative numbers.";
    public static final String EMPTY_LIST_ERROR = "List is empty. Please enter something.";
    public static final String DELETE_FORMAT_ERROR = "Wrong format, please enter in the format:\n\t delete [INDEX]";
    public static final String DELETE_INDEX_ERROR = "Index does not exist. Please refer to the list.";
    public static final String EMPTY_INPUT_ERROR = "Please enter something.";
    public static final String SEARCH_INPUT_ERROR = "Wrong format, please enter in the format:\n\t search "
            + "[NAME_OF_MOVE]";
    public static final String SEARCH_RESULTS_EMPTY = "No matching result has been found.";

    public static String saveCorruptedError(String filePath) {
        return (":( Save format in "
                + filePath + " is invalid.\n\t "
                + "File is cleared.");
    }

    public static String printHelp() {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter("Add", "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]",
                "Add a new move"));
        helpMessage.append(helpFormatter("List", "list",
                "Show all moves in this current session"));
        helpMessage.append(helpFormatter("Delete", "delete [INDEX]",
                "Delete a move according to the index in the list"));
        helpMessage.append(helpFormatter("Search", "search [NAME_OF_MOVE]",
                "Show a list of moves that match the entered keyword"));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to the Workout Menu"));
        return (helpMessage.toString().trim());
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
