package workout.workoutmanager.command;

import storage.workout.WorkOutManagerStorage;
import ui.workout.workoutmanager.WorkoutManagerUi;

public class DeleteWS extends Command {

    @Override
    public void execute(String[] args) {
        logger.info("entering delete command");
        int index = -1;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.warning("Number format exception caught");
            System.out.println("Input is not a number");
        } catch (NullPointerException e) {
            logger.warning("Null pointer exception caught");
            System.out.println("Insufficient arguments are given.");
        }
        WorkOutManagerStorage.delete(index);
        logger.info("deleted successfully");
        WorkoutManagerUi.printDeleteResponse();
    }
}
