package logic.commands.diet.dietmanager;

import logic.commands.Command;
import diet.dietsession.DietSession;
import logic.commands.CommandResult;
import storage.diet.DietStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static seedu.duke.Constant.PATH_TO_DIET_FOLDER;
import static ui.CommonUi.LS;

public class DietSessionList extends Command {
    /**
     * Overrides execute for list command to list diet sessions.
     *  @param input user input for command
     * @param storage storage for diet manager
     * @return CommandResult with list message
     */
    @Override
    public CommandResult execute(String input, DietStorage storage) {
        String message = "";
        File folder = new File(PATH_TO_DIET_FOLDER);
        File[] listOfFiles = folder.listFiles();
        StringBuilder listResult = new StringBuilder();
        assert folder.exists();
        try {
            String dietSessionListSize = "You have " + listOfFiles.length + " record(s)" + LS;
            String dietSessionList = formatList(listOfFiles, storage);
            listResult.append(dietSessionListSize);
            listResult.append(dietSessionList);
            message = listResult.toString();
            logger.log(Level.INFO, "Listed all available diet sessions");
        } catch (NullPointerException | NoSuchElementException e) {
            message = "Sorry! It seems like you have no diet sessions saved!";
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
        return new CommandResult(message);
    }

    private String formatList(File[] listOfFiles, DietStorage storage) {
        ArrayList<File> fileArrayList = new ArrayList<>();
        Collections.addAll(fileArrayList, listOfFiles);

        ArrayList<String> fileNames = (ArrayList<String>) fileArrayList.stream()
                .map(f -> f.getName().split(" ", 2)[1].trim()).collect(Collectors.toList());
        int descriptionMaxLenInt = Math.max(8,
                fileNames.stream().max(Comparator.comparingInt(String::length)).get().length());

        String descriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt + 1) + "s";

        String returnString = String.format("%-8s", "Index") + String.format(descriptionFormat, "Tags")
                + String.format("%-12s", "Date") + String.format("%-10s", "Calories") + LS;

        StringBuilder infoBuilder = new StringBuilder(returnString);

        String listDescriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt) + "s %-11s %s";
        for (int i = 0; i < fileArrayList.size(); i++) {
            DietSession ds = storage.readDietSession(listOfFiles[i].getName());
            double totalCalories = ds.getTotalCalories();
            String rowContent = String.format(listDescriptionFormat,
                    fileArrayList.get(i).getName().replaceFirst("[.][^.]+$", "").split(" ",2)[1],
                    fileArrayList.get(i).getName().replaceFirst("[.][^.]+$", "").split(" ",2)[0],
                    totalCalories);
            String row = String.format("%-8s", i + 1) + rowContent + LS;
            infoBuilder.append(row);
        }
        returnString = infoBuilder.toString().trim();
        return returnString;
    }
}
