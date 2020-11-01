package commands.diet.dietsession;

import commands.Command;
import diet.dietsession.Food;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static ui.CommonUi.LS;

public class FoodItemSearch extends Command {

    DietSessionUi ui = new DietSessionUi();

    /**
     * Overrides execute for search command to search food items.
     *
     * @param input user input for command
     * @param foodList arraylist that stored all the food items
     * @param storage storage for diet session
     * @param index Integer variable that shows the index of the session
     */
    @Override
    public void execute(String input, ArrayList<Food> foodList, DietStorage storage, Integer index) {
        try {

            StringBuilder searchResult = new StringBuilder();
            searchResult.append("Here are the search results: \n\t ");
            String formattedList = formatList(foodList, input.trim());
            searchResult.append(formattedList);
            ui.showToUser(searchResult.toString().trim());
            logger.log(Level.INFO, "Listed all searched foods in Diet Session");
        } catch (NullPointerException e) {
            ui.showToUser("Sorry, there is nothing in your food list.");
            logger.log(Level.WARNING, "No item in food list for search");
        }
    }

    private String formatList(ArrayList<Food> foodList, String searchTag) {

        ArrayList<String> foodNames = (ArrayList<String>) foodList.stream()
                .map(Food::getName).collect(Collectors.toList());
        int descriptionMaxLenInt = Math.max(10,
                foodNames.stream().max(Comparator.comparingInt(String::length)).get().length());

        String descriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt + 1) + "s";

        String returnString = String.format("%-8s", "Index") + String.format(descriptionFormat, "Food")
                + String.format("%-9s", "Calories") + LS;

        StringBuilder infoBuilder = new StringBuilder(returnString);

        String listDescriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt) + "s %-9s ";
        int numberOfResults = 0;
        for (int i = 0; i < foodList.size(); i++) {
            String foodName = foodList.get(i).getName();
            Double calories = foodList.get(i).getCalories();
            if (foodName.contains(searchTag)) {
                String rowContent = String.format(listDescriptionFormat, foodName, calories);
                String row = String.format("%-8s",  ++numberOfResults) + rowContent + LS;
                infoBuilder.append(row);
            }
        }
        String foodItemSearchSize = "\n\t You have " + numberOfResults + " record(s)" + LS;
        infoBuilder.append(foodItemSearchSize);
        if (numberOfResults == 0) {
            infoBuilder.setLength(0);
            infoBuilder.append("Sorry, there is nothing found in your food list.");
        }
        returnString = infoBuilder.toString().trim();
        return returnString;
    }
}
