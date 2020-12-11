package com.kate.notflixapp.controllers;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.service.UserService;
import com.kate.notflixapp.validator.UserValidator;
import com.kate.notflixapp.domainClasses.Mysql.UserM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;
    @Autowired
    private UserValidator userValidator;



    public UsersController( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/movies")
    public Iterable<MovieM> findmovies() {
        return userService.getMoviesOfUser((long) 1);
    }

    @GetMapping
    public Iterable<UserM> findusers() {
        return userService.getAllUsers();
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserM());

        return "registration";
    }


    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserM userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);

       // securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

}
