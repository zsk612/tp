package logic.parser;

import static profile.Constants.COMMAND_ARGS_INDEX;
import static profile.Constants.COMMAND_SPLIT_LIMIT;
import static profile.Constants.COMMAND_TYPE_INDEX;
import static profile.Constants.EMPTY_STRING;
import static profile.Constants.GREEDY_WHITE_SPACE;

//@@author tienkhoa16
/**
 * A base class for dealing with making sense of user command.
 */
public class CommonParser {

    /**
     * Parses and returns the Command associated with the user input.
     *
     * @param userInputString User's raw input string.
     * @return Size 2 array; first element is the command type and second element is the arguments string.
     */
    public String[] parseCommand(String userInputString) {
        String[] split = userInputString.trim().split(GREEDY_WHITE_SPACE, COMMAND_SPLIT_LIMIT);
        String commandType = split[COMMAND_TYPE_INDEX].toLowerCase();
        String commandArgs = (split.length == COMMAND_SPLIT_LIMIT ? split[COMMAND_ARGS_INDEX] : EMPTY_STRING);

        return new String[]{commandType, commandArgs};
    }
}
