package diet.dietsession;

import java.util.ArrayList;
import java.util.Scanner;

public class DietSessionParser {
    public static void dietSessionProcessCommand(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        dietSessionParser(in.nextLine().trim(), input);

//        switch (input.trim()){
//            case "add":
//
//        }
    }

    private static void dietSessionParser(String input, ArrayList<String> output){
    }
}
