package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.profile.RedundantParamException;
import profile.Profile;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.ADD_PROFILE_FORMAT;
import static profile.Constants.COMMAND_WORD_ADD;
import static profile.Constants.COMMAND_WORD_DELETE;
import static profile.Constants.COMMAND_WORD_EDIT;
import static profile.Constants.COMMAND_WORD_HELP;
import static profile.Constants.COMMAND_WORD_VIEW;
import static profile.Constants.EDIT_PROFILE_FORMAT;
import static ui.CommonUi.helpFormatter;

public class HelpProfile extends Command {

    /**
     * Constructs HelpProfile object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     * @throws RedundantParamException If parameters are provided to Help Command.
     */
    public HelpProfile(String commandArgs) throws RedundantParamException {
        if (!commandArgs.isEmpty()) {
            throw new RedundantParamException(COMMAND_WORD_HELP);
        }
    }

    /**
     * Overrides execute method of class Command to execute help command requested by user's input.
     *
     * @param profile User's Profile object.
     * @return Result of command execution.
     */
    @Override
    public Profile execute(Profile profile) {
        logger.log(Level.INFO, "executing Help Command");
        return profile;
    }

    /**
     * Overrides getExecutionResult method of class Command to get execution result after executing help command.
     *
     * @param profile User's profile.
     * @return Execution result.
     */
    @Override
    public CommandResult getExecutionResult(Profile profile) {
        StringBuilder helpMessage = new StringBuilder();

        helpMessage.append(helpFormatter(COMMAND_WORD_ADD, ADD_PROFILE_FORMAT, "Add your new profile"));
        helpMessage.append(helpFormatter(COMMAND_WORD_VIEW, COMMAND_WORD_VIEW, "View your profile"));
        helpMessage.append(helpFormatter(COMMAND_WORD_EDIT, EDIT_PROFILE_FORMAT, "Edit your existing profile. "
                + "You may edit only 1 field or all fields"));
        helpMessage.append(helpFormatter(COMMAND_WORD_DELETE, COMMAND_WORD_DELETE, "Delete your existing profile"));
        return new CommandResult(helpMessage.toString());
    }
}
