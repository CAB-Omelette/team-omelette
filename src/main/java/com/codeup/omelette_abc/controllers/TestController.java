package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

    public TestController(
                             ChefProfileRepository chefRepo,
                             UserService userSvc,
                             RestProfileRepository restRepo,
                             JobHistoryRepository jobHistRepo,
                             EducationRepository edRepo,
                             SkillsRepository skillsRepo,
                             JobPostRepository jobPostRepo) {
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
        this.jobPostRepo = jobPostRepo;
    }


    public boolean isOwner(){
        return userSvc.currentUser().isOwner() && restRepo.findFirstByUser(userSvc.currentUser()) != null;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("loggedIn", userSvc.isLoggedIn());
        if (!userSvc.isLoggedIn()) {
            model.addAttribute("user", new User());
            model.addAttribute("newJob", new JobListing());
        }
        return "/index";
    }

    @GetMapping("/loggedin")
    public String loggedIn(Model model) {
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("loggedIn", true);
        User user = userSvc.currentUser();
        model.addAttribute("isOwner", isOwner());
        return "/index";
    }

}

