package logic.commands.diet.dietsession;

import logic.commands.Command;
import diet.dietsession.Food;
import logic.commands.CommandResult;
import logic.commands.ExecutionResult;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.logging.Level;

//@@author zsk612
public class FoodItemClear extends Command {

    /**
     * Overrides execute for clear command to clear all food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     * @param index Integer variable that shows the index of the session
     * @return An object CommandResult containing the executing status and feedback message to be displayed
     *         to user.
     */
    @Override
    public CommandResult execute(String input, ArrayList<Food> foodList, DietStorage storage, Integer index) {
        String result = "";
        String prompt;
        if (index <= 0) {
            prompt = DietSessionUi.DIET_INPUT_PROMPT_NEW;
        } else {
            prompt = DietSessionUi.DIET_INPUT_PROMPT_EDIT + index;
        }
        if (ui.checkConfirmation(prompt, "clear all records")) {
            foodList.clear();
            result = "Alright, your food items have been cleared.";
            logger.log(Level.INFO, "Cleared all food in arraylist");
            return new CommandResult(result, ExecutionResult.OK);
        } else {
            result = "You have aborted clear operation.";
            return new CommandResult(result, ExecutionResult.ABORTED);
        }
    }
}
