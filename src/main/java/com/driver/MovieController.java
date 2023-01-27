package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director), HttpStatus.ACCEPTED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movieName,directorName), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-movies-by-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
        return new ResponseEntity<>(movieService.deleteDirectorByName(directorName), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.ACCEPTED);
    }
}
