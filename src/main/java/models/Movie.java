package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Movie {
    private String title;
    private Director[] director;
    private String genre;
    private String releaseDate;
    private List<Actor> actors;

    public Movie(){}

    @Override
    public String toString() {
        return "Movie: "+ title + "\n Director: " + director.toString() + "\n Genre: " + genre + "\n Actors: "+actors + "\n Date of release: " + releaseDate;
    }

}
