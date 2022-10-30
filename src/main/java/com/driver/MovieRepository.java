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

        for(Movie m : movies.values()){
            if(m.getName() == name){
                return m;
            }
        }
        return null;
    }

    public Director getDirector(String directorname) {
        for(Director d : directors.values()){
            if(d.getName() == directorname){
                return d;
            }
        }
        return null;
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
}
