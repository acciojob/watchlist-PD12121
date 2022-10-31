package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {

        HashMap<String,List<String>>DirectorMoviePair = new HashMap<>();
        private List<Director> directorList = new ArrayList<>();
        private List<Movie> movieList = new ArrayList<>();

        public void addmovie(Movie movie){
            movieList.add(movie);
        }


    public void addDirector(Director director) {
            directorList.add(director);
    }
    public List<Movie> getMovieList() {
            return movieList;
    }

    public List<Director> getDirectorList() {
            return directorList;
    }



    public void getDirectorMoviePair(String movieName, String directorName) {
       if(!DirectorMoviePair.containsKey(directorName)){
           DirectorMoviePair.put(directorName,new ArrayList<>());
       }
       DirectorMoviePair.get(directorName).add(movieName);
    }

    public List<String> getDirectorMovieByNameFormDatabase(String directorname) {
            List<String> allMoviesByDirector=new ArrayList<>();
            List<String>movies = DirectorMoviePair.get(directorname);
            for(int i=0;i<movies.size();i++){
                allMoviesByDirector.add(movies.get(i));
            }
           return allMoviesByDirector;
    }

    public void deleteMovieByName(String s) {
            int idx = movieList.indexOf(s);
            if(idx >= 0){
                movieList.remove(idx);
            }

    }

    public void deleteDirectorByName(String name) {
            int idx = directorList.indexOf(name);
            if(idx >=0){
                directorList.remove(idx);
            }

    }

    public void deleteAllDiretorsAndMovies() {
            for(String directorname : DirectorMoviePair.keySet()){
                List<String> moviesByDirectors = DirectorMoviePair.get(directorname);
                for(String s : moviesByDirectors){
                    this.deleteMovieByName(s);
                }
                deleteDirectorByName(directorname);

                DirectorMoviePair.remove(directorname);
            }

    }
}
