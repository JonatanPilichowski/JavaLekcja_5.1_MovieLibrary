package runner;

import models.MovieLibrary;

import static helpers.Menu.printMenu;
import static helpers.UserInputHelper.userInputNumber;
import static models.MovieLibrary.*;

public class Runner {

    public static void main(String[] args) {
        MovieLibrary movieLibrary = new MovieLibrary();
        movieLibrary.setMovies(getMoviesFromJson("src/main/resources/movies.json"));

        while (true) {
            printMenu();
            switch ( userInputNumber() ) {
                default -> System.out.println("Wrong value. Select options from 0 to 4.");
                case 1 -> getMoviesForReleaseDateRange(movieLibrary.getMovies());
                case 2 -> displayRandomMovie(movieLibrary.getMovies());
                case 3 -> getMoviesForInputActor(movieLibrary.getMovies());
                case 4 -> System.exit(0);
            }
        }

    }

}
