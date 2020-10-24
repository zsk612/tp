package commands;

import static profile.Constants.EMPTY_STRING;

/**
 * A class representing result shown to user after executing the requested command.
 */
public class CommandResult {
    private String feedbackMessage;
    private ExecutionResult status;

    /**
     * Constructs CommandResult object.
     *
     * @param feedbackMessage Feedback message after executing command.
     */
    public CommandResult(String feedbackMessage, ExecutionResult status) {
        this.feedbackMessage = feedbackMessage;
        this.status = status;
    }

    /**
     * Constructs CommandResult object with status OK.
     *
     * @param feedbackMessage Feedback message after executing command.
     */
    public CommandResult(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
        status = ExecutionResult.OK;
    }

    /**
     * Constructs CommandResult object with empty feedback message and status OK.
     */
    public CommandResult() {
        feedbackMessage = EMPTY_STRING;
        status = ExecutionResult.OK;
    }

    public ExecutionResult getStatus() {
        return status;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }
}
