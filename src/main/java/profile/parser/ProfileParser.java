package profile.parser;

import profile.exceptions.InvalidCommandWordException;

import static profile.Constants.ADD_PROFILE_WORD;
import static profile.Constants.COMMAND_ARGS_INDEX;
import static profile.Constants.COMMAND_SPLIT_LIMIT;
import static profile.Constants.COMMAND_TYPE_INDEX;
import static profile.Constants.EMPTY_STRING;
import static profile.Constants.GREEDY_WHITE_SPACE;

public class ProfileParser {

    /**
     * Parses and returns the Command associated with the user input.
     *
     * @param userInputString User's raw input string.
     * @return Associated command.
     * @throws InvalidCommandWordException If command word is invalid.
     */
    public String parseCommand(String userInputString) throws InvalidCommandWordException {
        String[] commandTypeAndParams = splitCommandWordAndArgs(userInputString);
        String commandType = commandTypeAndParams[COMMAND_TYPE_INDEX].toLowerCase();
        String commandArgs = commandTypeAndParams[COMMAND_ARGS_INDEX];

        switch (commandType) {
        case ADD_PROFILE_WORD:

        default:
            throw new InvalidCommandWordException();
        }
    }

    /**
     * Splits raw user's input into command word and command arguments string.
     *
     * @param rawUserInput User's raw input.
     * @return Size 2 array; first element is the command type and second element is the arguments string.
     */
    private String[] splitCommandWordAndArgs(String rawUserInput) {
        String[] split = rawUserInput.trim().split(GREEDY_WHITE_SPACE,
                COMMAND_SPLIT_LIMIT);

        return split.length == COMMAND_SPLIT_LIMIT ? split : new String[]{split[COMMAND_TYPE_INDEX], EMPTY_STRING};
    }
}
