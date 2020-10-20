package commands.profile;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.profile.InvalidAgeException;
import exceptions.profile.InvalidCommandFormatException;
import exceptions.profile.InvalidHeightException;
import exceptions.profile.InvalidWeightException;
import profile.Profile;

import java.util.HashMap;
import java.util.logging.Level;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static commands.ExecutionResult.SKIPPED;
import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.COMMAND_WORD_ADD;
import static profile.Constants.MESSAGE_CREATE_PROFILE_ACK;
import static profile.Constants.MESSAGE_PROFILE_EXIST;
import static profile.ProfileParser.extractAge;
import static profile.ProfileParser.extractCommandTagAndInfo;
import static profile.ProfileParser.extractExpectedWeight;
import static profile.ProfileParser.extractHeight;
import static profile.ProfileParser.extractName;
import static profile.ProfileParser.extractWeight;

/**
 * A representation of the command for adding profile.
 */
public class AddProfile extends Command {
    private String commandArgs;
    private ExecutionResult executionResult;

    /**
     * Constructs AddProfile object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     */
    public AddProfile(String commandArgs) {
        this.commandArgs = commandArgs;
        executionResult = SKIPPED;
    }

    /**
     * Overrides execute method of class Command to execute the add profile command requested by user's input.
     *
     * @param profile User's Profile object.
     * @return Result of command execution.
     */
    @Override
    public Profile execute(Profile profile) throws InvalidCommandFormatException, InvalidAgeException,
            InvalidHeightException, InvalidWeightException {

        logger.log(Level.INFO, "executing AddCommand");

        if (profile != null) {
            executionResult = FAILED;
            return profile;
        }

        HashMap<String, String> parsedParams = extractCommandTagAndInfo(COMMAND_WORD_ADD, commandArgs);
        profile = new Profile(
                extractName(parsedParams),
                extractAge(parsedParams),
                extractHeight(parsedParams),
                extractWeight(parsedParams),
                extractExpectedWeight(parsedParams)
        );

        executionResult = OK;

        return profile;
    }

    /**
     * Overrides getExecutionResult method of class Command to get execution result after executing add command.
     *
     * @param profile User's profile.
     * @return Execution result.
     */
    @Override
    public CommandResult getExecutionResult(Profile profile) {
        CommandResult result = null;

        if (executionResult == OK) {
            result = new CommandResult(String.format(MESSAGE_CREATE_PROFILE_ACK, profile.toString()));
        } else if (executionResult == FAILED) {
            result = new CommandResult(MESSAGE_PROFILE_EXIST);
        }

        assert (result != null) : "errors in setting execution flag";

        return result;
    }
}
