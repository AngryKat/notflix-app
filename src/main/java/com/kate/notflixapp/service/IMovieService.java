package com.kate.notflixapp.service;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Neo4j.MovieN;

public interface IMovieService {
    MovieN addMovie(MovieN m);
    MovieM addMovie(MovieM m);
    Iterable<MovieN> getMovieByTitleFromNeo(String title);
    Iterable<MovieM> getMovieByTitleFromMysql(String title);
    void deleteMovie(MovieN m);
    void deleteMovie(MovieM m);
    Iterable<MovieM> getAllMovies();
}
