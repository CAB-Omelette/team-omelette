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

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    private UsersRepository usersRepo;


    private UserService userSvc;

    public UserController(UsersRepository usersRepo, UserRepository userRepo, PasswordEncoder passwordEncoder, UserService userSvc) {
        this.usersRepo = usersRepo;
        this.userRepo = userRepo;
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
    public String saveChef(@Valid User user, Errors errors, Model model, @RequestParam ("email") String username) {

        if(usersRepo.findByUsername(username) != null){
            model.addAttribute("errors", errors);
            model.addAttribute("exists", true);
        }

        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "users/chefsignup";
        }

        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepo.save(user);
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