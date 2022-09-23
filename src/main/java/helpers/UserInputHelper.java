package helpers;

import java.util.HashMap;
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

    public static HashMap<String, Integer> getUserYearInput() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        System.out.println("Provide first year number in format YYYY:");
        hashMap.put("firstYear", userInputNumber());
        System.out.println("Provide second year number in format YYYY:");
        hashMap.put("secondYear", userInputNumber());
        return hashMap;
    }
    public static HashMap<String, String> getUserActorInput() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hashMap = new HashMap<>();
        System.out.println("Provide first name of the actor");
        hashMap.put("actorFirstName", scanner.nextLine());
        System.out.println("Provide last name of the actor");
        hashMap.put("actorLastName", scanner.nextLine());
        return hashMap;
    }
}
