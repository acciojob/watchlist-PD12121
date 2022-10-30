package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

     void deleteDirector(String name) {
      movieRepository.DeleteDirector(name);
    }

    List<Movie> getallMovies(){
        return movieRepository.getTheMovies();
    }

    void addMovie(Movie movie){
        movieRepository.addmovie(movie);
    }

    void addDirector(Director director){
        movieRepository.AddDirector(director);
    }


    public void DeleteAllDirectors() {
         movieRepository.deleteAllDirectors();
    }
}
