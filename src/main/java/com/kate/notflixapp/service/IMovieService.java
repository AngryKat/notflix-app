package com.kate.notflixapp.service;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Neo4j.MovieN;

import java.util.List;

public interface IMovieService {
    MovieN addMovie(MovieN m);
    MovieM addMovie(MovieM m);
    MovieN getMovieByTitleFromNeo(String title);
    MovieM getMovieByTitleFromMysql(String title);
    void deleteMovie(MovieN m);
    void deleteMovie(MovieM m);
    List<MovieM> getAllMovies();
}
