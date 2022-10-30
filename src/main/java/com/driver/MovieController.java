package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

   // HashMap<String,Movie>movies = new HashMap<>();

    @Autowired
            MovieService movieService;


    @Autowired
        MovieRepository movieRepository;



    //running successfully
    @PostMapping("/add-movie")
    public ResponseEntity<String>addMovie(@RequestBody(required = true)Movie movie){
       // movies.put(movie.getName(), movie);
        movieService.addMovie(movie);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    //running
    @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody()Director director){

        movieService.addDirector(director);

        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }


    //running
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<Movie>listOfMovies = movieService.getallMovies();

        return new ResponseEntity<>(listOfMovies,HttpStatus.OK);

    }

    // running but output is not there
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathParam("name")String name){

        Movie movie = movieRepository.getMovie(name);
        if(movie !=null){
            return new ResponseEntity(movie, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathParam("director")String directorname){
        Director director = movieRepository.getDirector(directorname);
        if(director != null){
            return new ResponseEntity(director, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@PathVariable("directorName")String name){
        movieService.deleteDirector(name);
        return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity  deleteAllDirectors(){
        movieService.DeleteAllDirectors();
        return new ResponseEntity("Sucess",HttpStatus.OK);
    }

}
