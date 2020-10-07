package diet.dietsession;

import java.util.Scanner;

public class DietSessionUI {

    public void printOpening() {
        System.out.println("start recording food: ");
    }

    public void printExit() {
        System.out.println("end diet session");
        System.out.println("you have exited DietSession.");
    }
    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
