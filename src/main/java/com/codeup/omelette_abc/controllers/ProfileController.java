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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
    private ProfileServices proSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

    public ProfileController(ProfileServices proSvc,
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

//    When a user clicks create a profile - this will determine if they already have a profile and if
// they are a rest or a chef and direct them to the correct profile creation page.


    @GetMapping("/createprofile")
    public String createProfile(Model model){
        if(userSvc.currentUser().isOwner() && !proSvc.hasRestProfile(userSvc.currentUser())){
            model.addAttribute("rest", new RestProfile());
            model.addAttribute("isOwner", true);
            return "newuser/newrestprofile";
        }else if (!userSvc.currentUser().isOwner() && !proSvc.hasChefProfile(userSvc.currentUser())){
            model.addAttribute("chef", new ChefProfile());
            return "newuser/newchefprofile";
        }
        return"redirect:/profile";
    }

//    Once a chef clicks submit on the profile creation form they will be directed to the
//    next portion of the profile which will be the job history form.
    @PostMapping("/newuser/newchefprofile")
    public String saveProfile(@ModelAttribute ChefProfile chefProfile, @RequestParam ("upload") String picture){
        chefProfile.setUser(userSvc.currentUser());
        chefProfile.setPicture(picture);
        chefRepo.save(chefProfile);
        return "redirect:/profile";
    }

    @PostMapping("/newuser/newrestprofile")
    public String saveRestProfile(@ModelAttribute RestProfile restProfile, Model model, @RequestParam ("upload") String picture){
        restProfile.setUser(userSvc.currentUser());
        restProfile.setPicture(picture);
        restRepo.save(restProfile);
        return "redirect:/profile";
    }

    @GetMapping("/jobhistory")
    public String addJobHistory(Model model){
        model.addAttribute("jobHistory", new JobHistory());
        return "newuser/chefjobhistory";
    }

    @GetMapping("/video")
    public String uploadVideo(){
        return("/newuser/omelettevideo");
    }

    @PostMapping("/video")
    public String saveVideo(ChefProfile chefProfile, @RequestParam ("video") String video){
        chefProfile.setUser(userSvc.currentUser());
        chefProfile.setVideo(video);
        return"redirect:/profile";
    }

    @PostMapping("/jobhistory")
    public String addJobHistory(@ModelAttribute JobHistory jobHistory){
        jobHistory.setUser(userSvc.currentUser());
        jobHistRepo.save(jobHistory);
        return "redirect:/profile";
    }


    @GetMapping("/education")
    public String chefEducation(Model model){
        model.addAttribute("education", new Education());
        return "newuser/education";
    }

    @PostMapping("/education")
    public String addEducation(@ModelAttribute Education education){
        education.setUser(userSvc.currentUser());
        edRepo.save(education);
        return "redirect:/profile";
    }


    @GetMapping("/skills")
    public String addSkill(Model model){
        model.addAttribute("skill", new Skills());
        return "/newuser/skills";
    }

    @PostMapping("/skills")
    public String addSkill(@ModelAttribute Skills skill){
        skill.setUser(userSvc.currentUser());
        skillsRepo.save(skill);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model){
        Boolean isOwner = userSvc.currentUser().isOwner();
        if(isOwner){
            model.addAttribute("isOwner", true);
            User user = userSvc.currentUser();
            model.addAttribute("rest", restRepo.findFirstByUser(user));
            model.addAttribute("jobs", jobPostRepo.findByUser(user));
            return"profiles/viewrestprofile";
        }else if(!userSvc.currentUser().isOwner()) {
            User user = userSvc.currentUser();
            model.addAttribute("user", user);
            model.addAttribute("chef", chefRepo.findByUser(user));
            model.addAttribute("jobs", jobHistRepo.findByUser(user));
            model.addAttribute("education", edRepo.findByUser(user));
            model.addAttribute("skills", skillsRepo.findByUser(user));
            return "profiles/viewchefprofile";
        }
        return "/home";
    }
}
