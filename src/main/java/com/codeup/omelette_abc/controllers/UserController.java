package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.UserRepository;
import com.codeup.omelette_abc.repositories.UsersRepository;
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

    private UsersRepository usersRepo;
    private PasswordEncoder passwordEncoder;


    private UserService userSvc;

    public UserController(UsersRepository usersRepo, PasswordEncoder passwordEncoder, UserService userSvc) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/signup";
    }



    @PostMapping("/sign-up")
    public String saveUser(@Valid User user, Errors errors, Model model, @RequestParam(defaultValue = "false") boolean isOwner) {
        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "users/signup";
        }

//        if (usersRepo.findByUsername(user.getUsername()) != null) {
//            errors.rejectValue("username", "user.username", "Duplicated username " + user.getUsername());
//            return "users/signup";
//        }

        if(isOwner){
            user.setOwner(true);
        }

        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() { return "users/login"; }


    @GetMapping("/map")
    public String googleMap() {
        return "/googlemaps";
    }

}
