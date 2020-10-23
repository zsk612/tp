package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;
import storage.workout.WorkOutManagerStorage;

import java.util.Scanner;

import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_SUCCESS;

public class ClearWS extends Command {

    @Override
    public CommandResult execute(String[] arg) throws SchwarzeneggerException {
        if (!checkConfirmation()) {
            return new CommandResult(CLEAR_ABORTED, ExecutionResult.ABORTED);
        }
        PastRecordList.getInstance().clear();
        return new CommandResult(CLEAR_SUCCESS, ExecutionResult.OK);
    }

    private static boolean checkConfirmation() {
        Scanner in = new Scanner(System.in);
        System.out.println("\tAre you sure you want to clear all records? This action is irrevocable.");
        System.out.println("\tKey in YES to confirm.");
        String input = in.next();
        return  input.equals("YES");
    }
}
