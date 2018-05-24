package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.*;
import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.ChefService;
import com.codeup.omelette_abc.services.RestProfileService;
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
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;
    private RestProfileService restSvc;
    private ChefService chefSvc;

    public ProfileController(
                             ChefProfileRepository chefRepo,
                             UserService userSvc,
                             RestProfileRepository restRepo,
                             JobHistoryRepository jobHistRepo,
                             EducationRepository edRepo,
                             SkillsRepository skillsRepo,
                             JobPostRepository jobPostRepo,
                             RestProfileService restSvc,
                             ChefService chefSvc) {
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
        this.jobPostRepo = jobPostRepo;
        this.restSvc = restSvc;
        this.chefSvc = chefSvc;
    }

    public boolean isOwner(){
        return userSvc.currentUser().isOwner() && restRepo.findFirstByUser(userSvc.currentUser()) != null;
    }



    @GetMapping("/createprofile")
    public String createProfile(Model model){
        User user = userSvc.currentUser();
        if(user.isOwner() && restRepo.findFirstByUser(user) == null){
            model.addAttribute("rest", new RestProfile());
            model.addAttribute("newJob", new JobListing());
            model.addAttribute("isOwner", isOwner());
            return "newuser/newrestprofile";
        }else if (!user.isOwner() && chefRepo.findByUser(user) == null){
            model.addAttribute("chef", new ChefProfile());
            model.addAttribute("newJob", new JobListing());
            return "newuser/newchefprofile";
        }
        return"redirect:/profile";
    }

    @PostMapping("/newuser/newchefprofile")
    public String saveChefProfile(@ModelAttribute ChefProfile chefProfile,Model model){
        chefProfile.setUser(userSvc.currentUser());
        model.addAttribute("newJob", new JobListing());
        chefProfile.setPicture("https://i.imgur.com/Lk4Awmf.png");
        chefRepo.save(chefProfile);
        return "redirect:/profile";
    }

    @PostMapping("/newuser/newrestprofile")
    public String saveRestProfile(@ModelAttribute RestProfile rest, Model model){
        rest.setUser(userSvc.currentUser());
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("isOwner", isOwner());
        rest.setPicture("https://i.imgur.com/Lk4Awmf.png");
        restRepo.save(rest);
        return "redirect:/profile";
    }

    @PostMapping("/newchef/picture")
    public String saveChefPicture(Model model, @ModelAttribute ChefProfile chef, @RequestParam(required = false, name="upload") String picture ){
        if(picture == null){
            model.addAttribute("chef", chef);
            model.addAttribute("newJob", new JobListing());
            return"redirect:/profile";
        }
        chef.setPicture(picture);
        model.addAttribute("newJob", new JobListing());
        chefRepo.save(chef);
        return"redirect:/profile";
    }

    @PostMapping("/newrest/picture")
    public String saveRestPicture(Model model, @ModelAttribute RestProfile rest, @RequestParam(required = false, name="upload") String picture ){
        if(picture == null){
            return"redirect:/profile";
        }
        model.addAttribute("rest", rest);
        rest.setPicture(picture);
        restRepo.save(rest);
        return"redirect:/profile";
    }

    @GetMapping("/newchef/video")
    public String uploadVideo(@ModelAttribute ChefProfile chefProfile, Model model){
        chefProfile = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("chef", chefProfile);
        return("/newuser/omelettevideo");
    }

    @PostMapping("/video")
    public String saveVideo(ChefProfile chefProfile, @RequestParam ("video") String video, Model model){
        chefProfile.setUser(userSvc.currentUser());
        chefProfile.setVideo(video);
        model.addAttribute("newJob", new JobListing());
        chefRepo.save(chefProfile);
        return"redirect:/profile";
    }


    @PostMapping("/jobhistory")
    public String addJobHistory(@ModelAttribute JobHistory jobHistory, Model model){
        jobHistory.setUser(userSvc.currentUser());
        model.addAttribute("newJob", new JobListing());
        jobHistRepo.save(jobHistory);
        return "redirect:/profile";
    }

    @PostMapping("/education")
    public String addEducation(@ModelAttribute Education education, Model model){
        model.addAttribute("newJob", new JobListing());
        education.setUser(userSvc.currentUser());
        edRepo.save(education);
        return "redirect:/profile";
    }

    @PostMapping("/skills")
    public String addSkill(@ModelAttribute Skills skill, Model model){
        model.addAttribute("newJob", new JobListing());
        skill.setUser(userSvc.currentUser());
        skillsRepo.save(skill);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model){
        User user = userSvc.currentUser();

        if(userSvc.isOwner()){
            model.addAttribute("newJob", new JobListing());
            model.addAttribute("noPicture", restSvc.hasPicture(user));
            model.addAttribute("isOwner", true);
            model.addAttribute("rest", restRepo.findFirstByUser(user));
            model.addAttribute("jobs", jobPostRepo.findByUser(user));
            return"profiles/viewrestprofile";
        }

        else if(!user.isOwner()) {
            model.addAttribute("newJob", new JobListing());
            model.addAttribute("newJobHistory", new JobHistory());
            model.addAttribute("newEducation", new Education());
            model.addAttribute("newSkill", new Skills());
            model.addAttribute("user", user);
            model.addAttribute("noPicture", chefSvc.hasPicture(user));
            model.addAttribute("chef", chefRepo.findByUser(user));
            model.addAttribute("jobs", jobHistRepo.findByUser(user));
            model.addAttribute("education", edRepo.findByUser(user));
            model.addAttribute("skills", skillsRepo.findByUser(user));
            return "profiles/viewchefprofile";
        }
        return "/home";
    }
}
