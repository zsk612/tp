package commands;

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
    public CommandResult(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
        this.status = ExecutionResult.OK;
    }

    public CommandResult(String feedbackMessage, ExecutionResult status) {
        this.feedbackMessage = feedbackMessage;
        this.status = status;
    }

    public CommandResult() {
        this.feedbackMessage = null;
        this.status = ExecutionResult.OK;
    }

    public ExecutionResult getStatus() {
        return status;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }
}
