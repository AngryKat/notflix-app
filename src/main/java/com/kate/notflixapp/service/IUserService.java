package com.kate.notflixapp.service;


import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Mysql.UserM;
import com.kate.notflixapp.domainClasses.Neo4j.UserN;

public interface IUserService {
    UserN addUser(UserN u);
    UserM addUser(UserM u);
    void deleteUser(UserN m);
    void deleteUser(UserM m);
    Iterable<UserM> getAllUsers();
    Iterable<MovieM> getMoviesOfUser(Long id);
    UserM findByUsername(String s);

}
