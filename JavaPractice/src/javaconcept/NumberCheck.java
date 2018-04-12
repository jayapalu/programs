package javaconcept;

import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/5/17.
 */
public class NumberCheck {

    public static void main(String[] args) {

        System.out.println("Input the any Integer number to check");
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        if (IntegerOrNot(input) && input.length() < 10) {
            System.out.println("Given number is Integer");
        } else {
            System.out.println("Given number is NOT Integer");
        }
    }

    public static boolean IntegerOrNot(String str) {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
