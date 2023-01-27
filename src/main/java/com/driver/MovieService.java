package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movieName,String DirectorName){
        movieRepository.addMovieDirectorPair(movieName, DirectorName);
    }
    public Movie getMovieByName(String movieName){
        return movieRepository.getMovie(movieName);
    }
    public Director getDirectorByName(String directorName){
        return movieRepository.getDirector(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return movieRepository.getMovies(directorName);
    }
    public List<String> findAllMovies(){
        return movieRepository.allMovies();
    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirector(directorName);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllMovies();
    }

}
