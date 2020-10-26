package profile;

import static ui.CommonUi.LS;

/**
 * Constants used in profile package.
 */
public class Constants {
    public static final int COMMAND_ARGS_INDEX = 1;
    public static final int COMMAND_SPLIT_LIMIT = 2;
    public static final int COMMAND_TYPE_INDEX = 0;

    public static final String ADD_PROFILE_FORMAT = "add /n [NAME] /h [HEIGHT] "
            + "/w [WEIGHT] /e [EXPECTED_WEIGHT] /c [DAILY_CALORIES_INTAKE]";
    public static final String EDIT_PROFILE_FORMAT = "edit </n [NAME]> </h [HEIGHT]> "
            + "</w [WEIGHT]> </e [EXPECTED_WEIGHT]> </c [DAILY_CALORIES_INTAKE]>";

    public static final String EMPTY_STRING = "";
    public static final String EXAMPLE_BMI = "32.0 (Obesity Class 1)";
    public static final double EXAMPLE_CALORIES = 2500;
    public static final double EXAMPLE_EXPECTED_WEIGHT = 100;
    public static final int EXAMPLE_HEIGHT = 188;
    public static final String EXAMPLE_NAME = "Schwarzenegger";
    public static final double EXAMPLE_WEIGHT = 113;
    public static final String GREEDY_WHITE_SPACE = "\\s+";
    public static final int HEIGHT_LOWER_BOUND = 63;
    public static final int HEIGHT_UPPER_BOUND = 231;
    public static final String HELP_FORMAT = "%-8s - %s" + LS + "%-8s %s" + LS;
    public static final String MESSAGE_CREATE_PROFILE_ACK = "Got it. Here's a confirmation of your profile:"
            + LS + "%s";
    public static final String MESSAGE_DELETE_PROFILE = "Alright! I've deleted your profile.";
    public static final String MESSAGE_EDIT_PROFILE_ACK = "Yay! Your profile is edited successfully. "
            + "Here's your new profile:" + LS + "%s";
    public static final String MESSAGE_END = "Returning to Main Menu...";
    public static final String MESSAGE_HELP_FOR_MORE_INFO = "For more information on command syntax, please type "
            + "\"help\".";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Wrong format, please enter in the format:" + LS
            + "%s" + LS + MESSAGE_HELP_FOR_MORE_INFO;
    public static final String MESSAGE_PROFILE_EXIST = "There's currently a profile in the database. " + LS
            + "Please delete it using \"delete\" command before adding a new one.";
    public static final String MESSAGE_PROFILE_NOT_EXIST = "There's no profile to %s. "
            + "Please add a new one using \"add\" command :D";
    public static final String MESSAGE_VIEW_PROFILE = "Here's your profile:" + LS + "%s";
    public static final String MESSAGE_WELCOME_EXISTING_USER = "Welcome back to Schwarzenegger, %s!" + LS
            + "How can I help you today?";
    public static final String MESSAGE_WELCOME_NEW_USER = "Welcome new user to Schwarzenegger! :D" + LS
            + "Please add your profile using \"add\" command under Profile Menu." + LS
            + MESSAGE_HELP_FOR_MORE_INFO;
    public static final String MESSAGE_WELCOME_WITH_INVALID_SAVE_FORMAT = "Welcome back to Schwarzenegger!" + LS
            + "It seems like your profile data is corrupted!" + LS
            + "Please add your profile again using \"add\" command under Profile Menu." + LS
            + MESSAGE_HELP_FOR_MORE_INFO;
    public static final String PROFILE_STRING_REPRESENTATION = "\tName: %s" + LS
            + "\tHeight: %d cm" + LS + "\tWeight: %.1f kg" + LS + "\tExpected Weight: %.1f kg"
            + LS + "\tExpected daily calories intake: %.1f calories" + LS + "\tYour BMI: %s";
    public static final String EXAMPLE_PROFILE_STRING = String.format(PROFILE_STRING_REPRESENTATION, EXAMPLE_NAME,
            EXAMPLE_HEIGHT, EXAMPLE_WEIGHT, EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES, EXAMPLE_BMI);
    public static final String SAD_FACE = ":(  OOPS!!! ";
    public static final String MESSAGE_INVALID_COMMAND_WORD = SAD_FACE + "Sorry, but I don't know what that means."
            + LS + "Please enter \"help\" for a list of available commands.";
    public static final String MESSAGE_INVALID_SAVE_FORMAT = SAD_FACE + "Save format in "
            + "saves\\profile\\profile.txt is invalid.";
    public static final String MESSAGE_INVALID_NAME = SAD_FACE + "Name cannot be empty.";
    public static final String MESSAGE_INVALID_CALORIES = SAD_FACE
            + "Expected daily calories intake cannot be negative.";
    public static final String MESSAGE_INVALID_HEIGHT = String.format(
            SAD_FACE + "Please input an integer from %d to %d for height.", HEIGHT_LOWER_BOUND, HEIGHT_UPPER_BOUND);
    public static final String MESSAGE_LOADING_ERROR = SAD_FACE + "An error has occurred while loading data."
            + LS + "%s";
    public static final String MESSAGE_SAVING_ERROR = SAD_FACE + "An error has occurred while saving data."
            + LS + "%s";
    public static final String MESSAGE_REDUNDANT_PARAM = SAD_FACE + "%s command does not take parameters.";
    public static final String MESSAGE_DELETE_NOTHING = SAD_FACE + "You haven't added any profile yet!";
    public static final String MESSAGE_EDIT_NOTHING = SAD_FACE
            + "The information you entered is the same as your current profile!";
    public static final double WEIGHT_LOWER_BOUND = 2.1;
    public static final double WEIGHT_UPPER_BOUND = 635;
    public static final String MESSAGE_INVALID_WEIGHT = String.format(
            SAD_FACE + "Please input a number from %.1f to %.1f for weight.", WEIGHT_LOWER_BOUND, WEIGHT_UPPER_BOUND);
}
