package commands;

/**
 * A class representing result shown to user after executing the requested command.
 */
public class CommandResult {
    private String feedbackMessage;
    private ExecutionResult status;

    public ExecutionResult getStatus() {
        return status;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

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

    /**
     * Overrides toString method of class Object to get string representation of CommandResult object.
     *
     * @return String representation of CommandResult object.
     */
    @Override
    public String toString() {
        return feedbackMessage;
    }
}

