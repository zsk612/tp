package seedu.duke;

import diet.dietmanager.DietManager;
import diet.dietmanager.DietManagerUI;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private final DietManagerUI dietManagerUI;
    private final DietManager dietManager;
    public Duke() {
        dietManagerUI = new DietManagerUI();
        dietManager = new DietManager();

    }

    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        execute();
    }

    public void execute() {
        String response = dietManagerUI.getInput();
        while (!response.equals("bye")) {

            if(response.equals("diet")) {
                dietManager.start();
            }
        }
        System.out.println("bye bye");
    }
}
