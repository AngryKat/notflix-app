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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class UserController {
    @Autowired
    MovieService movieService;
    Logger log = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;

    @RequestMapping("/user/favourites")
    public String movies(Model model, Authentication auth) {
        UserM user = userService.findByUsername(auth.getName());
        Iterable<MovieM> movies = userService.getMoviesOfUser(user.getId());
        List<MovieM> result = new ArrayList<>();
        for (MovieM u : movies) {
            result.add(u);
        }
        model.addAttribute("message", result);
        model.addAttribute("dislikedMovie", new MovieM());

        return "/favourites";
    }


   /* @PostMapping("/movies/dislike")
    public String movieDisliked(@ModelAttribute MovieM dislikedMovie, Model model, Authentication auth) {
        Logger log = Logger.getLogger(MovieController.class.getName());
        log.log(Level.INFO, dislikedMovie.getTitle());
        UserM user = userService.findByUsername(auth.getName());
        UserN userN = userService.findByUsernameNeo(auth.getName());
        MovieM movie = movieService.getMovieByTitleFromMysql(dislikedMovie.getTitle());
        MovieN movieN = movieService.getMovieByTitleFromNeo(dislikedMovie.getTitle());
        log.log(Level.INFO, "if in movie dislike "+user.getMovies().contains(movie));
        log.log(Level.INFO, "if in movie dislike "+userN.getLikes().contains(movieN));
        log.log(Level.INFO, "if in movie dislike "+movieN.getTitle());
        log.log(Level.INFO, "if in movie dislike "+movie.getTitle());

        if(user.getMovies().contains(movie) && userN.getLikes().contains(movieN)) {
            log.log(Level.INFO, "if in movie dislike");

            userService.removeMovie(movie, user);
            userService.removeMovieN(movieN, userN);
        }
        model.addAttribute("dislikedMovie", dislikedMovie);

        return "redirect:/user/favourites";
    }*/




}
