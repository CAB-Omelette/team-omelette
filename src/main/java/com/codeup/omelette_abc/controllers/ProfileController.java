package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.*;
import com.codeup.omelette_abc.repositories.*;
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
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;

    public ProfileController(ProfileServices proSvc,
                             ChefProfileRepository chefrepo,
                             UserService userSvc,
                             RestProfileRepository restRepo,
                             JobHistoryRepository jobHistRepo,
                             EducationRepository edRepo,
                             SkillsRepository skillsRepo) {
        this.proSvc = proSvc;
        this.chefRepo = chefrepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
    }

//    When a user clicks create a profile - this will determine if they are a rest or a chef
//    and direct them to the correct profile creation page.
    @GetMapping("/createprofile")
    public String createChefProfile(Model model){
        if(userSvc.currentUser().isOwner()){
            model.addAttribute("rest", new RestProfile());
            return "newuser/newrestprofile";
        }
        model.addAttribute("chef", new ChefProfile());
        return "newuser/newchefprofile";
    }

//    Once a chef clicks submit on the profile creation form they will be directed to the
//    next portion of the profile which will be the job history form.
    @PostMapping("/newuser/newchefprofile")

    public String saveProfile(@ModelAttribute ChefProfile chefProfile){
        chefProfile.setUser(userSvc.currentUser());
        chefRepo.save(chefProfile);
        return "redirect:/chefjobhistory";
    }

    @PostMapping("/newuser/newrestprofile")
    public String saveRestProfile(@ModelAttribute RestProfile restProfile){
        restProfile.setUser(userSvc.currentUser());
        restRepo.save(restProfile);
        return "/";
    }

    @GetMapping("/chefjobhistory")
    public String addJobHistory(Model model){
        model.addAttribute("jobHistory", new JobHistory());
        return "newuser/chefjobhistory";
    }

    @PostMapping("/newuser/chefjobhistory")
    public String saveRestProfile(@ModelAttribute JobHistory jobHistory){
        jobHistory.setUser(userSvc.currentUser());
        jobHistRepo.save(jobHistory);
        return "redirect:/chefjobhistory";
    }

    @GetMapping("/education")
    public String addEducation(Model model){
        model.addAttribute("education", new Education());
        return "newuser/education";
    }

    @PostMapping("/newuser/education")
    public String saveRestProfile(@ModelAttribute Education education){
        education.setUser(userSvc.currentUser());
        edRepo.save(education);
        return "redirect:/education";
    }

    @GetMapping("/newuser/skills")
    public String addSkill(Model model){
        model.addAttribute("skill", new Skills());
        return "/newuser/skills";
    }

    @PostMapping("/newuser/skills")
    public String saveSkill(@ModelAttribute Skills skill){
        skill.setUser(userSvc.currentUser());
        skillsRepo.save(skill);
        return "redirect:/newuser/skills";
    }


}
