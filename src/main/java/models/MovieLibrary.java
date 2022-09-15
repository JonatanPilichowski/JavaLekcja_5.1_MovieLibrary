package models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.Movie;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieLibrary {
    public static void main(String[] args) {


        List<Movie> movies = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            movies = Arrays.asList(objectMapper.readValue(Paths.get("src/main/resources/movies.json").toFile(), Movie[].class));
            movies.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Movie movie : movies) {
            System.out.println(movie.getDirector());

        }

        //  System.out.println(movies);
    }


}
