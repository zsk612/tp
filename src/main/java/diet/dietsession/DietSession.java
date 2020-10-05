package diet.dietsession;

import java.util.ArrayList;
import java.util.Scanner;

public class DietSession {
    public ArrayList<Food> foodList;
    private DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;
    Scanner sc = new Scanner(System.in);

    public DietSession () {
        this.foodList = new ArrayList<>();
    }

    public void setEndDietSession(Boolean hasEnded) {
        this.endDietSession = hasEnded;
    }

    public void dietSessionStart() {
        String input = null;

        setEndDietSession(false);

        while (!input.equals("end")) {
            input = sc.nextLine();
            parser.dietSessionProcessCommand(input, foodList);
        }
    }
}
