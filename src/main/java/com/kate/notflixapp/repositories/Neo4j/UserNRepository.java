package com.kate.notflixapp.repositories.Neo4j;

import com.kate.notflixapp.domainClasses.Neo4j.MovieN;
import com.kate.notflixapp.domainClasses.Neo4j.UserN;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserNRepository extends Neo4jRepository<UserN, Long> {

    @Query(" MATCH (user:User) WHERE user.username =$0 RETURN user")
    UserN findUserByUsername(String name);
    //Iterable<MovieN> get
    @Query(" MATCH (user:User)-[:LIKES]->(movie:Movie)\n" +
            "WHERE user.username = $0"+
            "RETURN user, movie")
    List<MovieN> getMoviesUserLikes(String name);


    @Query("MATCH (u:User {username: $0})-[:LIKES]->(:Movie)<-[:LIKES]-(o:User)\n" +
        "MATCH (o)-[:LIKES]->(rec:Movie)\n" +
        "WHERE NOT EXISTS( (u)-[:LIKES]->(rec) )\n" +
        "RETURN rec\n" +
        "LIMIT 25")
    List<MovieN> getMoviesRecommendedUser(String username);



}
