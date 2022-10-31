package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addmovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public Movie getMovieByName(String name){
        List<Movie>List = movieRepository.getMovieList();
        for(Movie m : List){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public Director getDirectorByName(String directorName) {
        List<Director>list = movieRepository.getDirectorList();
        for(Director d : list){
            if(d.getName().equals(directorName)){
                return d;
            }
        }
        return null;
    }

    public List<String> getallMovies() {
        List<String>listOfMovies= new ArrayList<>();
        List<Movie>movieList = movieRepository.getMovieList();
        for(Movie m : movieList){
            listOfMovies.add(m.getName());
        }
        return listOfMovies;
    }

    public void deleteDirectorByName(String name) {
        List<String>movielist = movieRepository.DirectorMoviePair.get(name);

        for(int i=0;i< movielist.size();i++){
           movieRepository.deleteMovieByName(movielist.get(i));
        }
        movieRepository.deleteDirectorByName(name);
    }

    public void DeleteAllDirectors() {
       movieRepository.deleteAllDiretorsAndMovies();
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
       movieRepository.getDirectorMoviePair(movieName,directorName);
    }

    public List<String> getDirectorMovieByName(String directorName) {
      return movieRepository.getDirectorMovieByNameFormDatabase(directorName);

    }


}
