package com.kate.notflixapp.controllers;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Mysql.UserM;
import com.kate.notflixapp.domainClasses.Neo4j.MovieN;
import com.kate.notflixapp.domainClasses.Neo4j.UserN;
import com.kate.notflixapp.service.MovieService;
import com.kate.notflixapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    UserService userService;

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public String findAll(Model model, Authentication auth) {
        UserM user = userService.findByUsername(auth.getName());
        Iterable<MovieM> ms = movieService.getAllMovies();
        List<MovieM> result = new ArrayList<>();
        for (MovieM m : ms) {
            result.add(m);
        }
        model.addAttribute("message", result);
        model.addAttribute("likedMovie", new MovieM());

        return "movies";
    }







}
