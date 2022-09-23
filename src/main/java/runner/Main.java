package runner;

import models.MovieLibrary;

import static helpers.JsonInputHelper.getMoviesFromJsonFile;
import static helpers.UserInputHelper.userInputNumber;

public class Main {
    private final static String filePath = "src/main/resources/movies.json";
    public static void main(String[] args) {
        MovieLibrary movieLibrary = getMoviesFromJsonFile(filePath);

        while (true) {
            printMenu();
            switch ( userInputNumber() ) {
                default -> System.out.println("Wrong value. Select options from 1 to 4.");
                case 1 -> movieLibrary.displayMoviesForInputDate();
                case 2 -> movieLibrary.displayRandomMovie();
                case 3 -> movieLibrary.displayMovieForActor();
                case 4 -> System.exit(0);
            }
        }

    }

    public static void printMenu() {
        System.out.println("""
        
        Select menu value from 1 to 4:
        1- Get all movies titles for provided release year date range.
        2- Get all the data for the random movie
        3- Get the titles of the movies for provided actor name
        4- Exit.
        """);
    }

}
