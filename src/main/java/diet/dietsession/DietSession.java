package diet.dietsession;

import diet.dietmanager.DietManagerUI;

import java.util.ArrayList;
import java.util.Scanner;

public class DietSession {
    public ArrayList<Food> foodList;
    private DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;
    private final DietManagerUI dietManagerUI;

    public DietSession () {
        this.foodList = new ArrayList<>();
        dietManagerUI = new DietManagerUI();
    }

    public void setEndDietSession(Boolean hasEnded) {
        this.endDietSession = hasEnded;
    }

    public void dietSessionStart() {

        setEndDietSession(false);

        System.out.println("start recording food: ");
        String input = dietManagerUI.getInput();
        while (!input.equals("end")) {
            parser.dietSessionProcessCommand(input, foodList);
            input = dietManagerUI.getInput();
        }
        setEndDietSession(true);
        System.out.println("end diet session");
    }
}
