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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private ChefProfileRepository chefrepo;
    private RestProfileRepository restrepo;

    private UserService userSvc;
    private ProfileServices proSvc;

    public ProfileController(ProfileServices proSvc, ChefProfileRepository chefrepo, UserService userSvc ) {
        this.proSvc = proSvc;
        this.chefrepo = chefrepo;
        this.userSvc = userSvc;

    }

    @GetMapping("/createprofile")
    public String createChefProfile(Model model){
        model.addAttribute("chef", new ChefProfile());
        return "newuser/newchefprofile";
    }

    @PostMapping("/createprofile")
    public String saveProfile(ChefProfile chefProfile){
        chefProfile.setUser(userSvc.currentUser());
        chefrepo.save(chefProfile);
        return "/profile";
    }

    @GetMapping("/createprofile")
    public String createRestProfile(Model model){
        model.addAttribute("rest", new RestProfile());
        return "newuser/newrestprofile";
    }

    @PostMapping("/createprofile")
    public String saveRestProfile(RestProfile restProfile){
        restProfile.setUser(userSvc.currentUser());
        restrepo.save(restProfile);
        return "/profile";
    }


}
