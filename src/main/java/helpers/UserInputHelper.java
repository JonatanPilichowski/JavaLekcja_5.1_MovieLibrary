package helpers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHelper {

    public static int userInputNumber() {
        while (true) {
            try {
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Only whole numbers accepted. Please try again.");
            }
        }
    }

    public static int validateNumber(String valueToValidate) {
        try {
            Integer.parseInt(valueToValidate);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(valueToValidate);
    }

}
