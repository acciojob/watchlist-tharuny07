package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    private Map<String,Movie> movieDB;
    private Map<String,Director> directorDB;
    private Map<String, List<String>> directorMovieDB;

    public MovieRepository() {
        this.movieDB = new HashMap<String,Movie>();
        this.directorDB = new HashMap<String,Director>();
        this.directorMovieDB = new HashMap<String,List<String>>();
    }
    public void addMovie(Movie movie){
        movieDB.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directorDB.put(director.getName(),director);
    }
    public void addMovieDirectorPair(String movieName,String directorName){
        if(movieDB.containsKey(movieName)&& movieDB.containsKey(directorName)){
            List<String> movies=new ArrayList<>();
            if(directorMovieDB.containsKey(directorName)) movies=directorMovieDB.get(directorName);
            movies.add(movieName);
            directorMovieDB.put(directorName,movies);
        }
    }
    public Movie getMovie(String movieName){
        return movieDB.get(movieName);
    }
    public Director getDirector(String directorName)
    {
        return directorDB.get(directorName);
    }
    public List<String> getMovies(String directorName){
        return directorMovieDB.get(directorName);
    }
    public List<String> allMovies(){
        return new ArrayList<>(movieDB.keySet());
    }
    public void deleteDirector(String directorName){
        if(directorMovieDB.containsKey(directorName)){
          //  List<String> movies=new ArrayList<>();
            for(String movie:directorMovieDB.get(directorName)){
                if(movieDB.containsKey(movie))
                  movieDB.remove(movie);
            }
           directorMovieDB.remove(directorName);
            if(directorDB.containsKey(directorName))
                  directorDB.remove(directorName);
        }
    }
    public void deleteAllMovies(){
        for(String director:directorDB.keySet()){
            deleteDirector(director);
        }
    }
}
