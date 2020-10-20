package ui.profile;

import ui.CommonUi;

import static profile.Constants.GREEDY_WHITE_SPACE;
import static profile.Constants.MESSAGE_WELCOME;
import static profile.Constants.SCANNER;

/**
 * A class that deals with interactions with user.
 */
public class ProfileUi extends CommonUi {

    /**
     * Greets user.
     *
     * @param name User's name.
     */
    public void greetUser(String name) {
        showToUser(String.format(MESSAGE_WELCOME, name));
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     *
     * @return Full line entered by the user.
     */
    public String getCommand() {
        System.out.print(">>>>> ");

        String inputLine = SCANNER.nextLine();

        // Silently consume all blank lines
        while (inputLine.trim().isEmpty()) {
            System.out.print(">>>>> ");
            inputLine = SCANNER.nextLine();
        }

        return inputLine.trim().replaceAll(GREEDY_WHITE_SPACE, " ");
    }
}
