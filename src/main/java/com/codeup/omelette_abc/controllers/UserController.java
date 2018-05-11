
package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.UserRepository;
import com.codeup.omelette_abc.repositories.UsersRepository;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (Model model, HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        model.addAttribute("newJob", new JobListing());
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @GetMapping("/rest/signup")
    public String newRest(Model model){
        model.addAttribute("newJob", new JobListing());

        model.addAttribute("user", new User());
        return"users/restsignup";
    }

    @GetMapping("/chef/signup")
    public String newChef(Model model){
        model.addAttribute("newJob", new JobListing());

        model.addAttribute("user", new User());
        return"users/chefsignup";
    }

    @PostMapping("/chef/signup")
    public String saveChef(@Valid User user, Errors errors, Model model, @RequestParam ("email") String username) {

        if(userSvc.userExists(username)){
            model.addAttribute("errors", errors);
            model.addAttribute("exists", true);
            return"/";
        }

        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "/";
        }
        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepo.save(user);
        return "redirect:/";
    }

    @PostMapping("/rest/signup")
    public String saveRest(@RequestParam ("email") String username, @Valid User user, Errors errors, Model model, @RequestParam(defaultValue = "false") boolean isOwner){
        if(userSvc.userExists(username)){
            model.addAttribute("errors", errors);
            model.addAttribute("newJob", new JobListing());
            model.addAttribute("exists", true);
            return"/";
        }
        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("newJob", new JobListing());
            model.addAttribute("user", user);
            return "/";
        }
        user.setUsername(user.getEmail());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setOwner(true);
        model.addAttribute("newJob", new JobListing());
        usersRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        if(!userSvc.isLoggedIn()){
            model.addAttribute("user", new User());
            model.addAttribute("newJob", new JobListing());
        }
        return "/index"; }


    @GetMapping("/map")
    public String googleMap() {
        return "/googlemaps";
    }


    @GetMapping("/AboutUs")
    public String AboutUs(Model model) {
        model.addAttribute("newJob", new JobListing());
        return "/AboutUs";
    }

}

