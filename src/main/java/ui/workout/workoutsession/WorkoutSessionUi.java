package ui.workout.workoutsession;

import ui.CommonUi;


public class WorkoutSessionUi extends CommonUi {
    private static CommonUi printer = new CommonUi();

    public static void printError() {
        printer.showToUser("There is an error, please restart the session");
    }

    public static void addFormatError() {
        printer.showToUser("Wrong format, please enter in the format: \n"
                + "\t add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w "
                + "[WEIGHT]");
    }

    public static void inputNotRecognisedError() {
        printer.showToUser("Command not recognised.");
    }

    public static void emptyListError() {
        printer.showToUser("List is empty. Please enter something.");
    }

    public static void deleteFormatError() {
        printer.showToUser("Wrong format, please enter in the format:\n\t delete [MOVE_ID]");
    }

    public static void deleteIndexError() {
        printer.showToUser("Index does not exist. Please refer to the list.");
    }

    public static void printHelp() {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter("Add", "add [NAME_OF_MOVE] /n [NUMBER_OF_REPETITIONS] /w [WEIGHT]",
                "Adds a new workout."));
        helpMessage.append(helpFormatter("List", "list",
                "Show all workouts in this current session."));
        helpMessage.append(helpFormatter("Delete", "delete [MOVE_ID]",
                "Deletes the workout according to the number in the list."));
        helpMessage.append(helpFormatter("Search", "search [NAME_OF_MOVE]",
                "Shows a list of workouts that match the entered workout."));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to the workout menu."));
        printer.showToUser(helpMessage.toString().trim());
    }

    public static void emptyInputError() {
        printer.showToUser("Please enter something.");
    }

    public static void searchInputError() {
        printer.showToUser("Wrong format, please enter in the format:\n\t search [NAME_OF_MOVE]");
    }

    public static void searchResultsEmpty() {
        printer.showToUser("No matching result has been found.");
    }
}
