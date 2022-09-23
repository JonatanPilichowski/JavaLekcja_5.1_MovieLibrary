package models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static helpers.UserInputHelper.*;

@Getter
@Setter

public class MovieLibrary {
    private List<Movie> movies;

    public MovieLibrary() {
        movies = new ArrayList<>();
    }

    private static boolean isEquals(String actorFirstName, String expectedName) {
        return Objects.equals(actorFirstName.toUpperCase(), expectedName.toUpperCase());
    }

    public void displayMoviesForInputDate() {
        HashMap<String, Integer> hashMap = getUserYearInput();
        List<String> titles = new ArrayList<>();
        for (Movie mov : getMovies()) {
            if (validateNumber(mov.getReleaseDate()) >= hashMap.get("firstYear") && validateNumber(mov.getReleaseDate()) <= hashMap.get("secondYear")) {
                titles.add(mov.getTitle());
            }
        }
        displayTitles(titles);
    }

    public void displayRandomMovie() {

        Random random = new Random();
        int randomNumber = random.nextInt(getMovies().size());
        System.out.println("Randomly selected movie:");
        System.out.println(getMovies().get(randomNumber));
    }

    public void displayMovieForActor() {
        HashMap<String, String> hashMap = getUserActorInput();
        List<String> titles = new ArrayList<>();
        for (Movie mov : getMovies()) {
            for (Actor act : mov.getActors()) {
                if (isEquals(hashMap.get("actorFirstName"), act.getFirstName()) && isEquals(hashMap.get("actorLastName"), act.getLastName())) {
                    titles.add(mov.getTitle());
                }
            }
        }
        displayTitles(titles);
    }

    private void displayTitles(List<String> titles) {
        if (titles.size() > 0) {
            System.out.println("Movie titles for search criteria:");
            System.out.println(Arrays.toString(titles.toArray()).replace("[", "").replace("]", ""));
        } else {
            System.out.println("There was no movies for this criteria in the movie library.");
        }
    }
}
