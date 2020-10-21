package ui;

import java.util.Scanner;

import static profile.Constants.EMPTY_STRING;
import static profile.Constants.HELP_FORMAT;

public class CommonUi {
    protected static final String LINE_PREFIX = "\t ";
    public static final String LS = System.lineSeparator() + LINE_PREFIX;
    protected static final String HORIZONTAL_LINE = LINE_PREFIX
            + "____________________________________________________________";
    protected static final String MESSAGE_FORMAT_GENERAL = HORIZONTAL_LINE + LS + "%s" + System.lineSeparator()
            + HORIZONTAL_LINE + System.lineSeparator();

    /**
     * Shows a message to the user.
     *
     * @param result Message to be displayed.
     */
    public void showToUser(String result) {
        System.out.println(String.format(MESSAGE_FORMAT_GENERAL, result));
    }

    public static void showUser(String result) {
        System.out.println(String.format(MESSAGE_FORMAT_GENERAL, result));
    }

    public static void printHelpFormatter(String commandName, String commandFormat, String description) {
        System.out.format("%-8s - %s\n", commandName, commandFormat);
        System.out.format("%-8s %s\n", "", description);
    }

    public static String helpFormatter(String commandName, String commandFormat, String description) {
        return String.format(HELP_FORMAT, commandName, commandFormat, EMPTY_STRING, description);
    }

    /**
     * Formatter to get a input from user.
     * @param menuName current menu name
     * @return user input in a string
     */
    public String getCommand(String menuName) {
        System.out.print(menuName+ " >>>>> ");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();

        // Silently consume all blank lines
        while (inputLine.trim().isEmpty()) {
            System.out.print(menuName + " >>>>> ");
            inputLine = sc.nextLine();
        }
        return inputLine;
    }

}
