package com.kate.notflixapp.domainClasses.Neo4j;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label="User")
public class UserN {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Relationship(type = "LIKES")
    private List<MovieN> likes = new ArrayList<>();

    public UserN() {
    }

    public UserN(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
