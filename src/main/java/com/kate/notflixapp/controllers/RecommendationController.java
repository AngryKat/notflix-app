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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user/recommendations")
public class RecommendationController {
    @Autowired
    MovieService movieService;
    Logger log = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;

        @GetMapping
        public String movies(Model model, Authentication auth) {
            UserN user = userService.findByUsernameNeo(auth.getName());
            List<MovieN> movies = userService.getRecommendedMovies(user.getUsername());

            model.addAttribute("message", movies);
            model.addAttribute("likedMovie", new MovieM());

            return "recommended";
        }
}
