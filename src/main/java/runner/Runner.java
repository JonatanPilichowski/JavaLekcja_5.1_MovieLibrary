package runner;

import models.Movie;
import models.MovieLibrary;

import java.util.List;

import static helpers.JsonInputHelper.getMoviesFromJson;
import static helpers.UserInputHelper.userInputNumber;
import static models.MovieLibrary.*;

public class Runner {

    public static void main(String[] args) {
        List<Movie> movies;
        movies = getMoviesFromJson("src/main/resources/movies.json");


        while(true){

            switch(userInputNumber()){
                default -> System.out.println("Wrong value. Select options from 0 to 4.");
                case 1 -> displayWholeMovieLibrary(movies);
                case 2 -> getMoviesForInputActor(movies);
                case 3 -> getMoviesForReleaseDateRange(movies);
                case 4 -> System.exit(0);
            }
        }

    }

}
