package workout.workoutsession;

import commands.Command;
import commands.CommandLib;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.exercise.Exercise;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class WorkoutSession {
    private String filePath = null;
    private boolean[] endWorkoutSession;
    public ArrayList<Exercise> exerciseList;

    private transient CommandLib cl;
    private final Storage storage;

    public WorkoutSession(String filePath) {
        this.filePath = filePath;
        this.exerciseList = new ArrayList<>();
        this.storage = new Storage();
        this.endWorkoutSession = new boolean[1];
    }

    private void setEndWorkoutSessionF() {

        this.endWorkoutSession[0] = false;
    }

    /**
     * Starts workout session.
     */
    public void workoutSessionStart() {

        setEndWorkoutSessionF();
        logger.log(Level.INFO, "starting workout session");
        this.cl = new CommandLib();
        cl.initWorkoutSessionCL();
        Scanner in = new Scanner(System.in);

        try {
            storage.readFileContents(filePath, exerciseList);
        } catch (FileNotFoundException e) {
            WorkoutSessionUi.printError();
        }

        while (!endWorkoutSession[0]) {
            try {
                WorkoutSessionUi.inputPrompt();
                workoutSessionProcessCommand(in.nextLine().trim());
            } catch (NullPointerException e) {
                WorkoutSessionUi.emptyInputError();
            }
        }
    }

    private void workoutSessionProcessCommand(String input) throws NullPointerException {
        String[] commParts = WorkoutSessionParser.workoutSessionParser(input.trim());
        Command command = cl.get(commParts[0]);
        command.execute(commParts, exerciseList, filePath, storage, endWorkoutSession);
    }

}
