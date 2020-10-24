package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import models.PastRecordList;
import workout.workoutsession.WorkoutSession;

import java.util.ArrayList;

import static commands.ExecutionResult.OK;
import static ui.workout.workoutmanager.WorkoutManagerUi.NEW_SUCCESS;
import static ui.workout.workoutmanager.WorkoutManagerUi.STARTNEWSESSION;
import static workout.workoutmanager.WorkoutManagerParser.parseTags;

public class NewWS extends Command {

    /**
     * Creates new workout session.
     *
     * @param args list of tags to be attached to a new session.
     * @return Status OK and feedback message.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        /**
         * When starting a new workout session, a new file is created first.
         * The file path is passed into workoutSession constructor to instantiate
         * a new workoutSession instance.
         */
        super.execute(args);
        ArrayList<String> tags = parseTags(args);
        String filePath = PastRecordList.getInstance().add(tags);
        WorkoutSession ws = new WorkoutSession(filePath);
        logger.info("New workout session created");

        ui.showToUser(STARTNEWSESSION);

        ws.workoutSessionStart();

        logger.info("Ended workout session");
        return new CommandResult(NEW_SUCCESS, OK);
    }
}
