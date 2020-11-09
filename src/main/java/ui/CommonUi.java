package ui;

import java.util.Scanner;

import static logic.parser.CommonParser.GREEDY_WHITE_SPACE;

//@@author tienkhoa16
/**
 * A base class for interacting with user.
 */
public class CommonUi {

    public static final String EMPTY_STRING = "";
    public static final String LINE_PREFIX = "\t ";
    public static final String LS = System.lineSeparator() + LINE_PREFIX;
    public static final String LOGO = "   _____        _" + LS
            + "  / ____|      | |" + LS
            + " | (___    ___ | |__ __      __ __ _  _ __  ____ ___  _ __    ___   __ _   __ _   ___  _ __ " + LS
            + "  \\___ \\  / __|| '_ \\\\ \\ /\\ / // _` || '__||_  // _ \\| '_ \\  / _ \\ / _` | / _` | / _ \\| "
            + "'__|" + LS
            + "  ____) || (__ | | | |\\ V  V /| (_| || |    / /|  __/| | | ||  __/| (_| || (_| ||  __/| |" + LS
            + " |_____/  \\___||_| |_| \\_/\\_/  \\__,_||_|   /___|\\___||_| |_| \\___| \\__, | \\__, | \\___||_|" + LS
            + "                                                                    __/ |  __/ |" + LS
            + "                                                                   |___/  |___/";
    public static final String HELP_FORMAT = "%-8s FORMAT:      %s" + LS + "%-8s DESCRIPTION: %s" + LS;
    public static final String WARNING_FORMAT = "! WARNING: %s!";
    public static final String MESSAGE_CLEAR_FORMAT = "Alright, your %s been cleared!";
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

    /**
     * Formats help messages.
     *
     * @param commandName Name of command.
     * @param commandFormat Format of command.
     * @param description Description of command.
     * @return Formatted help string.
     */
    public static String helpFormatter(String commandName, String commandFormat, String description) {
        return String.format(HELP_FORMAT, commandName, commandFormat, EMPTY_STRING, description);
    }

    /**
     * Formats clear messages.
     *
     * @param content Content of clear message.
     * @return Formatted help string.
     */
    public static String clearMsgFormatter(String content) {
        return String.format(MESSAGE_CLEAR_FORMAT, content);
    }

    /**
     * Formats the header of search records.
     *
     * @param num The number of matching records.
     * @param plurality Either "has" or "have" depending on the number of matching records found.
     * @return Formatted header for search records.
     */
    public static String searchRecords(int num, String plurality) {
        return String.format("%d %s been found!", num, plurality) + LS;
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
