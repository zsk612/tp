package profile;

import static ui.CommonUi.LS;

//@@author tienkhoa16
/**
 * Constants used in profile-related code.
 */
public class Constants {
    public static final int COMMAND_ARGS_INDEX = 1;
    public static final int COMMAND_SPLIT_LIMIT = 2;
    public static final int COMMAND_TYPE_INDEX = 0;

    public static final String ADD_PROFILE_FORMAT = "add /n [NAME] /h [HEIGHT] "
            + "/w [CURRENT_WEIGHT] /e [EXPECTED_WEIGHT] /c [DAILY_CALORIE_INTAKE]";
    public static final String EDIT_PROFILE_FORMAT = "edit </n [NAME]> </h [HEIGHT]> "
            + "</w [CURRENT_WEIGHT]> </e [EXPECTED_WEIGHT]> </c [DAILY_CALORIE_INTAKE]>";

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
    public static final String PROFILE_STRING_REPRESENTATION = "\tName: %s" + LS
            + "\tHeight: %d cm" + LS + "\tWeight: %.1f kg" + LS + "\tExpected Weight: %.1f kg"
            + LS + "\tExpected daily calorie intake: %.1f calories" + LS + "\tYour BMI: %s";
    public static final double WEIGHT_LOWER_BOUND = 2.1;
    public static final double WEIGHT_UPPER_BOUND = 635;
    public static final double CALORIES_UPPER_BOUND = 200000;
    public static final double CALORIES_LOWER_BOUND = 0;
}
