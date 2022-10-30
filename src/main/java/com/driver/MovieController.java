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

        try {
            Movie movie = movieService.getMovie(name);
            return new ResponseEntity<>(movie,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathParam("director")String directorname){
       try {
           Director d = movieService.getDirector(directorname);
           return new ResponseEntity<>(d,HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
       }

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

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName")String movieName,@RequestParam("directorName")String directorName){

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("directorName")String directorName){
        List<Movie>moviesByDirector = movieService.getDirectorMovie(directorName);
        return new ResponseEntity(moviesByDirector,HttpStatus.OK);
    }
}
