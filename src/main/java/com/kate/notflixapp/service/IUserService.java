package com.kate.notflixapp.service;


import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Mysql.UserM;
import com.kate.notflixapp.domainClasses.Neo4j.MovieN;
import com.kate.notflixapp.domainClasses.Neo4j.UserN;

import java.util.List;

public interface IUserService {
    UserN addUser(UserN u);
    UserM addUser(UserM u);
    void deleteUser(UserN m);
    void deleteUser(UserM m);
    List<UserM> getAllUsers();
    List<MovieM> getMoviesOfUser(Long id);
    List<MovieN> getRecommendedMovies(String username);
    UserM findByUsername(String s);
    UserN findByUsernameNeo(String s);
    void addMovie(MovieN m, UserN u);
    void addMovie(MovieM m, UserM u);
    void removeMovie(MovieM m, UserM u);
    void removeMovieN(MovieN m, UserN u);

}
