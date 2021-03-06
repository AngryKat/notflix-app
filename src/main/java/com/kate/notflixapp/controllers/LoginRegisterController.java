package com.kate.notflixapp.controllers;

import com.kate.notflixapp.domainClasses.Mysql.UserM;
import com.kate.notflixapp.domainClasses.Neo4j.UserN;
import com.kate.notflixapp.service.UserService;
import com.kate.notflixapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserM());

        return "registration";
    }



    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserM userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        UserN userN = new UserN(userForm.getUsername());

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);
        userService.addUser(userN);

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

}
