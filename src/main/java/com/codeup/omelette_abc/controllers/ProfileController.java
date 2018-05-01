package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.services.ProfileServices;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;


    private UserService userSvc;
    private ProfileServices proSvc;

    public ProfileController(ProfileServices proSvc, ChefProfileRepository chefrepo, UserService userSvc, RestProfileRepository restRepo ) {
        this.proSvc = proSvc;
        this.chefRepo = chefrepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
    }

    @GetMapping("/createprofile")
    public String createChefProfile(Model model){
        if(userSvc.currentUser().isOwner()){
            model.addAttribute("rest", new RestProfile());
            return "newuser/newrestprofile";
        }
        model.addAttribute("chef", new ChefProfile());
        return "newuser/newchefprofile";
    }

    @PostMapping("/newuser/newchefprofile")

    public String saveProfile(@ModelAttribute ChefProfile chefProfile){
        chefProfile.setUser(userSvc.currentUser());
        chefRepo.save(chefProfile);
        return "redirect:/profile";
    }

    @PostMapping("/newuser/newrestprofile")
    public String saveRestProfile(@ModelAttribute RestProfile restProfile){
        restProfile.setUser(userSvc.currentUser());
        restRepo.save(restProfile);
        return "redirect:/profile";
    }

}
