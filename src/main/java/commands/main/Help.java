package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;

import static ui.CommonUi.helpFormatter;
import static ui.CommonUi.printHelpFormatter;
import static ui.CommonUi.showUser;

public class Help extends Command {

    @Override
    public CommandResult execute(String[] args) {

        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter("profile", "profile",
                "Go to Profile Manager to update your profile"));
        helpMessage.append(helpFormatter("workout", "workout",
                "Go to Workout Manager to manager your workout records" +
                        " and create new workout records"));
        helpMessage.append(helpFormatter("diet", "diet",
                "Go to Workout Manager to manager your past diet records" +
                        " and create new diet records"));
        helpMessage.append(helpFormatter("end", "end",
                "Exit the program"));
        showUser(helpMessage.toString().trim());
        return new CommandResult("", ExecutionResult.OK);
    }
}
