package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;

import static ui.CommonUi.helpFormatter;

public class HelpWS extends Command {

    /**
     * Executes help command in Workout Menu.
     *
     * @param args Array of user's input.
     * @return Status OK and information to be printed.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String args) throws SchwarzeneggerException {
        super.execute(args);
        String helpMessage = helpFormatter("List", "list </s [START DATE]> </e [END DATE]>",
                "Show all past sessions. Can display sessions between a certain period")
                + helpFormatter("New", "new </t [TAG]...>",
                "Create a new workout session and tags. Multiple tags are seperated by ','.")
                + helpFormatter("Delete", "delete [INDEX]",
                "Delete the record indexed at x")
                + helpFormatter("Edit", "edit [INDEX]",
                "Edit the record indexed at x")
                + helpFormatter("Clear", "clear",
                "Clear all past results")
                + helpFormatter("Search", "search </t [TAG]...> </d [DATE]>",
                "Search records based on tags and dates. Multiple tags are seperated by ','.")
                + helpFormatter("End", "end",
                "Go back to Main Menu");
        return new CommandResult(helpMessage.trim(), ExecutionResult.OK);
    }
}
