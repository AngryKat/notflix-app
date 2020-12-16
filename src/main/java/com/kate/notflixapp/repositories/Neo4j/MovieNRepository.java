package com.kate.notflixapp.repositories.Neo4j;

import com.kate.notflixapp.domainClasses.Neo4j.MovieN;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Jennifer Reif
 */
public interface MovieNRepository extends Neo4jRepository<MovieN, Long> {
    MovieN findByTitle(String title);

}
