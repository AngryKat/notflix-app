package com.kate.notflixapp.repositories.Neo4j;

import com.kate.notflixapp.domainClasses.Neo4j.UserN;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserNRepository extends Neo4jRepository<UserN, Long> {
}
