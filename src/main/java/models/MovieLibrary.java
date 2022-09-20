package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;
import java.util.*;

import static helpers.UserInputHelper.userInputNumber;
import static helpers.UserInputHelper.validateNumber;

@Getter
@Setter

public class MovieLibrary {
    private List<Movie> movies;

    public MovieLibrary() {
        movies = new ArrayList<>();
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

    public static void getMoviesForReleaseDateRange(List<Movie> movieLibrary) {
        System.out.println("Provide first year number in format YYYY:");
        int firstYear = userInputNumber();
        System.out.println("Provide second year number in format YYYY:");
        int secondYear = userInputNumber();
        for (Movie mov : movieLibrary) {
            if (validateNumber(mov.getReleaseDate()) >= firstYear && validateNumber(mov.getReleaseDate()) <= secondYear) {
                System.out.println(mov.getTitle());
            }
        }
    }

    public static void displayRandomMovie(List<Movie> movieLibrary) {

        Random random = new Random();
        int randomNumber = random.nextInt(movieLibrary.size());
        System.out.println(movieLibrary.get(randomNumber));
    }

    public static void getMoviesForInputActor(List<Movie> movies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide first name of the actor");
        String actorFirstName = scanner.nextLine();
        System.out.println("Provide last name of the actor");
        String actorLastName = scanner.nextLine();
        for (Movie mov : movies) {
            for (Actor act : mov.getActors()) {
                if (isEquals(actorFirstName, act.getFirstName()) && isEquals(actorLastName, act.getLastName())) {
                    System.out.println(mov.getTitle());
                }
            }
        }
    }

    private static boolean isEquals(String actorFirstName, String expectedName) {
        return Objects.equals(actorFirstName.toUpperCase(), expectedName.toUpperCase());
    }


}
