package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.UserRepository;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository users;
    private PasswordEncoder passwordEncoder;


    private UserService userSvc;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder, UserService userSvc) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
    }

    @GetMapping("/profilechoice")
    public String showSignupForm(Model model) {
        return "users/profilechoice";
    }

    @GetMapping("/rest/signup")
    public String newRest(Model model){
        model.addAttribute("user", new User());
        return"users/restsignup";
    }

    @GetMapping("/chef/signup")
    public String newChef(Model model){
        model.addAttribute("user", new User());
        return"users/chefsignup";
    }



    @PostMapping("/chef/signup")
    public String saveChef(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "users/chefsignup";
        }
        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @PostMapping("/rest/signup")
    public String saveRest(@Valid User user, Errors errors, Model model, @RequestParam(defaultValue = "false") boolean isOwner) {
        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "users/restsignup";
        }
        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setOwner(true);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() { return "users/login"; }


    @GetMapping("/map")
    public String googleMap() {
        return "/googlemaps";
    }

}