package com.kate.notflixapp.domainClasses.Mysql;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="movie")
public class MovieM {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private int released;
    private String description;
    private String image_id;
    @JsonIgnore
    @ManyToMany(mappedBy = "likedMovies")
    Set<UserM> likes;


    public Set<UserM> getLikes() {
        return likes;
    }

    public void setLikes(Set<UserM> likes) {
        this.likes = likes;
    }


    public MovieM() {
    }

    public MovieM(String title, int released, String tagline, String image_id) {
        this.title = title;
        this.released = released;
        this.description = tagline;
        this.image_id = image_id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
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

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


}
