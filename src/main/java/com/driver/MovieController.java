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
    @Autowired
            MovieService movieService;


    //running successfully
    //1
    @PostMapping("/add-movie")
    public ResponseEntity<String>addMovie(@RequestBody(required = true)Movie movie){
       // movies.put(movie.getName(), movie);
        movieService.addMovie(movie);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    //running 2
    @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody()Director director){

        movieService.addDirector(director);

        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    //3
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){

        Movie ans = movieService.getMovieByName(name);
        return new ResponseEntity<>(ans,HttpStatus.CREATED);

    }

    //4
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){

        Director d = movieService.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.CREATED);


    }
    //running 7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String>listOfMovies = movieService.getallMovies();

        return new ResponseEntity<>(listOfMovies,HttpStatus.OK);

    }
    //8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Success",HttpStatus.OK );
    }

    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>  deleteAllDirectors(){
        movieService.DeleteAllDirectors();
        return new ResponseEntity("Success",HttpStatus.OK);
    }

    //3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename")String moviename,@RequestParam("directorname")String directorname){
        movieService.addMovieDirectorPair(moviename,directorname);
        return new ResponseEntity("Success",HttpStatus.OK);
    }

    //6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String>moviesByDirector = movieService.getDirectorMovieByName(director);
        return new ResponseEntity(moviesByDirector,HttpStatus.OK);
    }
}
