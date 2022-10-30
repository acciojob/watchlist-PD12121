package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {

        HashMap<String,Movie>movies = new HashMap<>();
        HashMap<String ,Director>directors=new HashMap<>();


    List<Movie>getTheMovies(){
            List<Movie>movieList = new ArrayList<>();

            for(Movie movie : movies.values()){
                movieList.add(movie);
            }

            return movieList;
        }

        void addmovie(Movie movie){
            movies.put(movie.getName(),movie);
        }


        void AddDirector(Director director){
            directors.put(director.getName(),director);
        }


    public Movie getMovie(String name) {

        Movie m = movies.get(name);
        return m;
    }

    public Director getDirector(String directorname) {
        Director d = directors.get(directorname);
        return d;
    }

    public void DeleteDirector(String name) {
        movies.remove(name);
        directors.remove(name);
    }

    public void deleteAllDirectors() {
        for(String d : directors.keySet()){
            if(movies.containsKey(d)){
                movies.remove(d);
            }
        }
        directors.clear();
    }

    public List<Movie> getMovies(String directorName) {
        List<Movie>movieList = new ArrayList<>();
        if(movies.containsKey(directorName)){
            movieList.add(movies.get(directorName));
        }

        return movieList;
    }
}
