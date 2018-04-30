package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.services.ProfileServices;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private ChefProfileRepository chefrepo;

    private UserService userSvc;
    private ProfileServices proSvc;

    public ProfileController(ProfileServices proSvc, ChefProfileRepository chefrepo, UserService userSvc ) {
        this.proSvc = proSvc;
        this.chefrepo = chefrepo;
        this.userSvc = userSvc;
    }

    @GetMapping("/createprofile")
    public String createChefProfile(Model model){
//        if(userSvc.currentUser().isOwner()){
//            model.addAttribute("rest", new RestProfile());
//            return "newuser/newrestprofile";
//        }
        model.addAttribute("chef", new ChefProfile());
        return "newuser/newchefprofile";
    }

    @PostMapping("/newuser/newchefprofile")
    public String saveProfile(@ModelAttribute ChefProfile chefProfile){
        chefProfile.setUser(userSvc.currentUser());
        chefrepo.save(chefProfile);
        return "redirect:/success";
    }

//Creat a new postmapping controller for /newuser/newrestprofile
// and make sure that on that form the action is set as newuser/newrestprofile

}
