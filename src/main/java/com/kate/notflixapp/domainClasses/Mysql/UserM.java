package com.kate.notflixapp.domainClasses.Mysql;


import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class UserM {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
    @Transient
    private String passwordConfirm;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_likes_movie",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<MovieM> likedMovies;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    /*@JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )*/
    Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> permissions) {
        this.roles = permissions;
    }

    public UserM(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public UserM() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Set<MovieM> getMovies() {
        return likedMovies;
    }

    public void setMovies(Set<MovieM> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public void addMovie(MovieM movie) {
        this.likedMovies.add(movie);
        movie.getLikes().add(this);
    }

    public void removeMovie(MovieM movie) {
        this.likedMovies.remove(movie);
        movie.getLikes().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
