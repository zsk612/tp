package ui.diet.dietmanager;

import ui.CommonUi;

public class DietManagerUi extends CommonUi {
    public static String DIET_FILE_ARRAY_OUT_OF_BOUND = "Sorry, there is no file at that index.";
    public static String DIET_NEW_SUCCESS = "Exiting Diet Session!";
    public static String DIET_DELETE_SUCCESS = "You have deleted that diet session!";
    public static String DIET_EDIT_WRONG_FORMAT = "Wrong format, please enter in the format:\n\t "
            + "edit [INDEX_OF_SESSION]";
    public static String DIET_DELETE_WRONG_FORMAT = "Wrong format, please enter in the format:\n\t delete [INDEX]";
    public static String DIET_CREATE_WRONG_FORMAT = "Wrong format, please enter in the format: \\n\\t \"\n" +
            "                    + \"new </d [DATE]> </t [TAG]>";
    public static String DIET_DATE_WRONG_FORMAT = "Wrong format for date input.";
    public static String DIET_NO_SESSIONS_SAVED = "It looks like you have no sessions saved!";
    public static String DIET_SEARCH_RESULTS_MESSAGE = "Here are the search results!";
    public static String DIET_SEARCH_EMPTY_TAG = "Tag is empty, "
            + "all the sessions within input dates will be shown.";
}
