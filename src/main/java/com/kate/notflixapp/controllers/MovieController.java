package com.kate.notflixapp.controllers;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Neo4j.MovieN;
import com.kate.notflixapp.service.MovieService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jennifer Reif
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    //private final MovieNRepository movieRepository;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

   // public MovieController(MovieNRepository movieRepository) {
     //   this.movieRepository = movieRepository;
    //}

    @GetMapping
    public Iterable<MovieM> findAll() {
       return movieService.getAllMovies();
    }


}
