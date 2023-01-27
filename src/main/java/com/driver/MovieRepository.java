package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

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
        List<String> movies=new ArrayList<>();
        if(directorMovieDB.containsKey(directorName)) movies=directorMovieDB.get(directorName);
        return movies;
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
        Set<String> movieSet=new HashSet<>();
        for(String director:directorMovieDB.keySet()){
            for(String movie:directorMovieDB.get(director)){
                movieSet.add(movie);
            }
            if(directorDB.containsKey(director)) directorDB.remove(director);
            directorMovieDB.remove(director);
        }
        for(String movies:movieSet){
            if(movieDB.containsKey(movies)){
                movieDB.remove(movies);
            }
        }
    }
}
