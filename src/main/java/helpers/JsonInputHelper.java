package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Movie;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonInputHelper {

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
}
