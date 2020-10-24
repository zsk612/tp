package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;

import java.util.Scanner;

import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_SUCCESS;

public class ClearWS extends Command {

    /**
     * Constructor of ClearWS.
     * @param args user inputs into a list of string
     * @return Status OK and feedback message if the execution is affirmed
     *         Status ABORTED if the execution is withdrawn
     * @throws SchwarzeneggerException if error occurs writing to file
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        super.execute(args);
        if (!checkConfirmation()) {
            return new CommandResult(CLEAR_ABORTED, ExecutionResult.ABORTED);
        }
        PastRecordList.getInstance().clear();
        logger.info("Cleared successfully");
        return new CommandResult(CLEAR_SUCCESS, ExecutionResult.OK);
    }

    private static boolean checkConfirmation() {
        Scanner in = new Scanner(System.in);
        System.out.println("/tAre you sure you want to clear all records? This action is irrevocable.");
        System.out.println("\tKey in 'YES' to confirm.");
        String input = ui.getCommand("Workout Manager");
        return input.equals("YES");
    }
}
