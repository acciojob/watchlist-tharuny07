package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
        movieRepository.addMovie(movie);
        return "success";
    }
    public String addDirector(Director director){
        movieRepository.addDirector(director);
        return "success";
    }
    public String addMovieDirectorPair(String movieName,String DirectorName){
        movieRepository.addMovieDirectorPair(movieName, DirectorName);
        return "success";
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

    public String deleteDirectorByName(String directorName){
        movieRepository.deleteDirector(directorName);
        return "success";
    }
    public String deleteAllDirectors(){
        movieRepository.deleteAllMovies();
        return "success";
    }

}
