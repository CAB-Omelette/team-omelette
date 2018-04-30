package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.UserRepository;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/signup";
    }

    @PostMapping("/sign-up")
    public String saveUser( @Valid User user, Model model, @RequestParam(defaultValue = "false") boolean isOwner) {
        if(isOwner){
            user.setOwner(true);
        }
        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }


    @GetMapping("/profile")
    public String loggedIn(Model model){
        if(userSvc.isLoggedIn()){
            model.addAttribute("user", userSvc.currentUser());
            return"redirect:/profile";
        }
        return"/login";
    }

    @GetMapping("/map")
    public String googleMap() {
        return "/googlemaps";
    }

    @GetMapping("/success")
    public String loggedIn(){
        return"/success";

    }




}
