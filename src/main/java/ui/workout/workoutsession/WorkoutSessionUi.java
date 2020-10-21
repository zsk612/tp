package ui.workout.workoutsession;

import ui.CommonUi;


public class WorkoutSessionUi extends CommonUi{
    private static CommonUi printer = new CommonUi();

    public static void printError() {
        printer.showToUser("There is an error, please restart the session");
    }

    public static void addFormatError() {
        printer.showToUser("Wrong format, please enter in the format: \n"
                + "\t add [workout] /n [number of sets] /w "
                + "[weight]");
    }

    public static void inputNotRecognisedError() {
        printer.showToUser("Command not recognised.");
    }

    public static void emptyListError() {
        printer.showToUser("List is empty. Please enter something.");
    }

    public static void printHelp() {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter("Add", "add [name of move] /n [number of repetitions] /w [weight]",
                "Adds a new workout."));
        helpMessage.append(helpFormatter("List", "list",
                "Show all workouts in this current session."));
        helpMessage.append(helpFormatter("Delete", "delete [move ID]",
                "Deletes the workout according to the number in the list."));
        helpMessage.append(helpFormatter("Search", "search [name of move]",
                "Shows a list of workouts that match the entered workout."));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to the workout menu."));
        printer.showToUser(helpMessage.toString().trim());
    }
}
