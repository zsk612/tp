package commands.workout.workoutmanager.command;

import commands.Command;
import storage.workout.WorkOutManagerStorage;
import ui.workout.workoutmanager.WorkoutManagerUi;
import workout.workoutsession.WorkoutSession;

public class NewWS extends Command {

    @Override
    public void execute(String[] args) {
        /**
         * When starting a new workout session, a new file is created first.
         * The file path is passed into workoutSession constructor to instantiate
         * a new workoutSession instance.
         */
        String filePath = WorkOutManagerStorage.add();
        WorkoutSession ws = new WorkoutSession(filePath);
        logger.info("new workout session created");

        WorkoutManagerUi.printStartNewSessionResponse();

        ws.workoutSessionStart();

        logger.info("ended workout session");
        WorkoutManagerUi.printFinishNewSessionResponse();

    }
}
