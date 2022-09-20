package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class Movie {
    @JsonProperty("title")
    private String title;
    @JsonProperty("director")
    private Director director;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("actors")
    private List<Actor> actors;

    public Movie() {
    }


    @Override
    public String toString() {
        return "Movie: "
                + title + "\n Director: "
                + director + "\n Genre: "
                + genre + "\n Actors: "
                + Arrays.toString(actors.toArray()).replace("[", "").replace("]", "")
                + "\n Date of release: "
                + releaseDate + "\n";
    }

}
