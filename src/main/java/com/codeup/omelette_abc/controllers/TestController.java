package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.ProfileService;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
    private ProfileService proSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

    public TestController(ProfileService proSvc,
                          ChefProfileRepository chefRepo,
                          UserService userSvc,
                          RestProfileRepository restRepo,
                          JobHistoryRepository jobHistRepo,
                          EducationRepository edRepo,
                          SkillsRepository skillsRepo,
                          JobPostRepository jobPostRepo) {
        this.proSvc = proSvc;
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
        this.jobPostRepo = jobPostRepo;
    }



    @GetMapping("/")
    public String showIndex(Model model) {
        return "/index";
    }

    @GetMapping("/loggedin")
    public String loggedIn(Model model) {
        if(userSvc.currentUser().isOwner()) {
            model.addAttribute("isOwner", true);
        }
        return "/index";
    }


}

