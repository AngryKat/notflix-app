package com.kate.notflixapp.domainClasses.Neo4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

/**
 * @author Jennifer Reif
 */
@NodeEntity(label="Movie")
public class MovieN {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private int released;

    @JsonIgnoreProperties("movie")
    @Relationship(type = "LIKES", direction = INCOMING)
    private List<UserN> users = new ArrayList<>();


    public MovieN() {
    }

    public MovieN(String title, int released) {
        this.title = title;
        this.released = released;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

}
