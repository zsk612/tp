package storage;

import diet.dietmanager.DietManagerUI;
import diet.dietsession.DietSession;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class DietManagerStorage {
    private static List<DietSession> pastRecords;
    private final DietManagerUI ui = new DietManagerUI();

    public void init() {
        pastRecords = new ArrayList<>();
    }

    public void list() {
        int index = 1;
        for(DietSession record : pastRecords) {
            System.out.print((index++) + " " +
                    record.getMealInput() + " on " + record.getDateInput() + "\n");
        }

    }

    public void add(String input) {

        try {
            String dateInput = ui.extractDate(input);
            String mealInput = ui.extractMeal(input);
            System.out.println("date: " + dateInput);
            System.out.println("meal: " + mealInput);
            DietSession ds = new DietSession(dateInput, mealInput);
            System.out.println("You have created a new session.");
            ds.start();
            pastRecords.add(ds);
        } catch (DateTimeParseException | IllegalStateException e) {
            System.out.println("Sorry I do not understand this input.");
        }
    }
}
