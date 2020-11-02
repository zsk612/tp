package ui;

import java.util.Scanner;

import static profile.Constants.EMPTY_STRING;
import static profile.Constants.GREEDY_WHITE_SPACE;

public class CommonUi {
    public static final String LINE_PREFIX = "\t ";
    public static final String LS = System.lineSeparator() + LINE_PREFIX;
    public static final String HELP_FORMAT = "%-8s - %s" + LS + "%-8s %s" + LS;
    public static final String WARNING_FORMAT = "! WARNING: %s!";
    public static final String HORIZONTAL_LINE = LINE_PREFIX
            + "_________________________________________________________________________________________________";
    public static final String MESSAGE_FORMAT_GENERAL = HORIZONTAL_LINE + LS + "%s" + System.lineSeparator()
            + HORIZONTAL_LINE + System.lineSeparator();

    /**
     * Shows a message to the user.
     *
     * @param result Message to be displayed.
     */
    public void showToUser(String result) {
        assert result != null : "result should not be null";
        System.out.println(String.format(MESSAGE_FORMAT_GENERAL, result));
    }

    public static void showUser(String result) {
        System.out.println(String.format(MESSAGE_FORMAT_GENERAL, result));
    }

    public static String helpFormatter(String commandName, String commandFormat, String description) {
        return String.format(HELP_FORMAT, commandName, commandFormat, EMPTY_STRING, description);
    }

    /**
     * Prints formatted warning message.
     *
     * @param message Warning message.
     */
    public void showWarning(String message) {
        showToUser(String.format(WARNING_FORMAT, message));
    }

    /**
     * Gets input from user.
     *
     * @param menuName Current menu name.
     * @return User input in a string.
     */
    public String getCommand(String menuName) {
        System.out.print(menuName + " >>>>> ");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();

        // Silently consume all blank lines
        while (inputLine.trim().isEmpty()) {
            System.out.print(menuName + " >>>>> ");
            inputLine = sc.nextLine();
        }

        return inputLine.replaceAll(GREEDY_WHITE_SPACE, " ").trim();
    }

    /**
     * Gets user confirmation a specific command.
     *
     * @param menuName Current menu name.
     * @param action Action description.
     * @return If user confirms the command execution.
     */
    public boolean checkConfirmation(String menuName, String action) {
        String message = String.format("Are you sure you want to %s? This action is irrevocable.\n\t "
                + "Key in \"YES\" to confirm.", action);
        showToUser(message);
        String input = getCommand(menuName);
        return input.equals("YES");
    }

    /**
     * Prints opening message to user.
     *
     * @param menuName Name of menu entering.
     */
    public void printOpening(String menuName) {
        showToUser(String.format("Starting %s...", menuName));
    }

    /**
     * Prints returning message to user.
     *
     * @param menuName Name of menu to return to.
     */
    public void printReturning(String menuName) {
        showToUser(String.format("Returning to %s...", menuName));
    }
}
