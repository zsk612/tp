package seedu.duke;

import diet.dietmanager.DietManager;
import logger.SchwarzeneggerLogger;
import profile.ProfileSession;
import ui.diet.dietmanager.DietManagerUi;
import workout.workoutmanager.WorkoutManager;

/**
 * The Schwarzenegger program implements an application that keeps track of the user's gym and diet record.
 */
public class Duke {
    private final DietManagerUi dietManagerUI;
    private final DietManager dietManager;

    public Duke() {
        dietManagerUI = new DietManagerUi();
        dietManager = new DietManager();
        SchwarzeneggerLogger.initSchwarzeneggerLogger();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args Unused in Duke.
     */

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runs Schwarzenegger.
     */
    private void run() {
        System.out.println("Greetings from Schwarzenegger!");
        System.out.print("Main menu >>>>> ");
        String response = dietManagerUI.getInput().trim();
        while (!response.equals("end")) {
            if (response.equals("diet")) {
                dietManager.start();
            }

            if (response.equals("profile")) {
                System.out.println("Entering Profile Session...");

                ProfileSession profileSession = new ProfileSession();
                profileSession.run();
            }

            if (response.equals("workout")) {
                System.out.println("Entering Workout Session...");
                WorkoutManager workoutManager = new WorkoutManager();
                workoutManager.start();
            }
            System.out.print("Main menu >>>>> ");
            response = dietManagerUI.getInput().trim();
        }
        System.out.println("Bye, you have exited the Schwarzenegger.");
    }
}