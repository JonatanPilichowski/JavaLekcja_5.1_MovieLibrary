package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.MovieLibrary;

import java.io.File;

public class JsonInputHelper {

    public static MovieLibrary getMoviesFromJsonFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        MovieLibrary movies = null;
        try {
            movies = mapper.readValue(new File(path), MovieLibrary.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}
