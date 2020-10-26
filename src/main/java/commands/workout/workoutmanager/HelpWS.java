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
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter("List", "list",
                "Show all past sessions"));
        helpMessage.append(helpFormatter("New", "new /t <tag1> <tag2>",
                "Create a new workout session and tags"));
        helpMessage.append(helpFormatter("Delete", "delete x",
                "Delete the record indexed at x"));
        helpMessage.append(helpFormatter("Edit", "edit x",
                "Edit the record indexed at x"));
        helpMessage.append(helpFormatter("Clear", "clear",
                "Clear all past results"));
        helpMessage.append(helpFormatter("Search", "search /t <tag1> <tag2> /d <date>",
                "Search records based on tags and dates"));
        helpMessage.append(helpFormatter("End", "end",
                "Go back to Main Menu"));
        return new CommandResult(helpMessage.toString().trim(), ExecutionResult.OK);
    }
}
