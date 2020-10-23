package commands.workout.workoutmanager;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import models.PastRecordList;
import ui.workout.workoutmanager.WorkoutManagerUi;
import workout.workoutsession.WorkoutSession;

import java.util.ArrayList;
import java.util.logging.Logger;

import static commands.ExecutionResult.OK;
import static ui.workout.workoutmanager.WorkoutManagerUi.NEW_SUCCESS;
import static workout.workoutmanager.WorkoutManagerParser.parseTags;

public class NewWS extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    @Override
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        /**
         * When starting a new workout session, a new file is created first.
         * The file path is passed into workoutSession constructor to instantiate
         * a new workoutSession instance.
         */
        ArrayList<String> tags = parseTags(args);
        String filePath = PastRecordList.getInstance().add(tags);
        WorkoutSession ws = new WorkoutSession(filePath);
        logger.info("new workout session created");

        WorkoutManagerUi.printStartNewSessionResponse();

        ws.workoutSessionStart();

        logger.info("ended workout session");
        return new CommandResult(NEW_SUCCESS, OK);
    }
}
