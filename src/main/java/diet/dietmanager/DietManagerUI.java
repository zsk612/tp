package diet.dietmanager;

import java.util.Scanner;

public class DietManagerUI {

    public static void printOpening() {
        System.out.println("You're now in diet manager!");
    }

    public static void printBye() {
        System.out.println("Exiting diet manager!!");
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}