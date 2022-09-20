package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.nio.file.Paths;
import java.util.*;

import static helpers.UserInputHelper.userInputNumber;
import static helpers.UserInputHelper.validatedValue;
@Getter

public class MovieLibrary {
    private List<Movie> movies;
    public MovieLibrary(){
        movies = new ArrayList<>();
    }
    public static void main(String[] args) {


        List<Movie> movieLibrary = null;
        movieLibrary = getMoviesFromJson("src/main/resources/movies.json");


        switch(userInputNumber()){
            default -> System.out.println("Wrong value. Select options from 0 to 4.");
            case 1 -> displayWholeMovieLibrary(movieLibrary);
            case 2 -> getMoviesForInputActor(movieLibrary);
            case 3 -> getMoviesForReleaseDateRange(movieLibrary);
            case 4 -> System.exit(0);
        }



    }

    public static void getMoviesForReleaseDateRange(List<Movie> movieLibrary) {
        System.out.println("Provide first year number in format YYYY:");
        int firstYear = userInputNumber();
        System.out.println("Provide second year number in format YYYY:");
        int secondYear = userInputNumber();
        for (Movie mov : movieLibrary) {
            if (validatedValue(mov.getReleaseDate()) >= firstYear && validatedValue(mov.getReleaseDate()) <= secondYear) {
                System.out.println(mov);
            }
        }
    }

    public static void displayWholeMovieLibrary(List<Movie> movieLibrary) {
        for (Movie mov : movieLibrary) {
            System.out.println(mov.toString());}
    }

    public static List<Movie> getMoviesFromJson(String path) {
        List<Movie> movieLibrary = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            movieLibrary = Arrays.asList(objectMapper.readValue(Paths.get(path).toFile(), Movie[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieLibrary;
    }

    public static void getMoviesForInputActor(List<Movie> movies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide first name of the actor");
        String actorFirstName = scanner.nextLine();
        System.out.println("Provide last name of the actor");
        String actorLastName = scanner.nextLine();
        for (Movie mov : movies) {
            for (Actor act : mov.getActors()) {
                if (!(Objects.equals(actorFirstName, act.getFirstName()))) break;
                if (!(Objects.equals(actorLastName, act.getLastName()))) break;
                System.out.println(mov);
            }
        }
    }


}
