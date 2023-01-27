package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieDB;
    private HashMap<String,Director> directorDB;
    private HashMap<String, List<String>> directorMovieDB;

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
        if(movieDB.containsKey(movieName)&& directorDB.containsKey(directorName)){
            movieDB.put(movieName,movieDB.get(movieName));
            directorDB.put(directorName,directorDB.get(directorName));
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
        List<String> movies=new ArrayList<String>();
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
        HashSet<String> movieSet=new HashSet<String>();
        for(String director:directorMovieDB.keySet()){
            for(String movie:directorMovieDB.get(director)){
                movieSet.add(movie);
            }
        }
        for(String movies:movieSet){
            if(movieDB.containsKey(movies)){
                movieDB.remove(movies);
            }
        }
    }
}
