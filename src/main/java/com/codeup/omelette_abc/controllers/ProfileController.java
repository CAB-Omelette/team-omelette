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



    @GetMapping("/createprofile")
    public String createProfile(Model model){
        User user = userSvc.currentUser();
        if(user.isOwner() && restRepo.findFirstByUser(user) == null){
            model.addAttribute("rest", new RestProfile());
            model.addAttribute("isOwner", true);
            return "newuser/newrestprofile";
        }else if (!user.isOwner() && chefRepo.findByUser(user) == null){
            model.addAttribute("chef", new ChefProfile());
            return "newuser/newchefprofile";
        }
        return"redirect:/profile";
    }

    @PostMapping("/newuser/newchefprofile")
    public String saveChefProfile(@ModelAttribute ChefProfile chefProfile){
        chefProfile.setUser(userSvc.currentUser());
        chefProfile.setPicture("https://i.imgur.com/Lk4Awmf.png");
        chefRepo.save(chefProfile);
        return "redirect:/profile";
    }

    @PostMapping("/newuser/newrestprofile")
    public String saveRestProfile(@ModelAttribute RestProfile rest){
        rest.setUser(userSvc.currentUser());
        rest.setPicture("https://i.imgur.com/Lk4Awmf.png");
        restRepo.save(rest);
        return "redirect:/profile";
    }

    @GetMapping("/newchef/picture")
    public String addChefPic(@ModelAttribute ChefProfile chefProfile, Model model){
        chefProfile = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chefProfile);
        return"/newuser/chefpicupload";
    }

    @GetMapping("/newrest/picture")
    public String addRestPic(@ModelAttribute RestProfile rest, Model model){
        rest = restRepo.findFirstByUser(userSvc.currentUser());
        model.addAttribute("rest", rest);
        return"/newuser/restpicupload";
    }

    @PostMapping("/newchef/picture")
    public String saveChefPicture(@ModelAttribute ChefProfile chef, @RequestParam(required = false, name="upload") String picture ){
        if(picture == null){
            return"redirect:/profile";
        }
        chef.setPicture(picture);
        chefRepo.save(chef);
        return"redirect:/profile";
    }

    @PostMapping("/newrest/picture")
    public String saveRestPicture(@ModelAttribute RestProfile rest, @RequestParam(required = false, name="restPic") String picture ){
        if(picture == null){
            return"redirect:/profile";
        }
        rest.setPicture(picture);
        restRepo.save(rest);
        return"redirect:/profile";
    }

    @GetMapping("/jobhistory")
    public String addJobHistory(Model model){
        model.addAttribute("jobHistory", new JobHistory());
        return "newuser/chefjobhistory";
    }

    @GetMapping("/newchef/video")
    public String uploadVideo(@ModelAttribute ChefProfile chefProfile, Model model){
        chefProfile = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chefProfile);
        return("/newuser/omelettevideo");
    }

    @PostMapping("/video")
    public String saveVideo(ChefProfile chefProfile, @RequestParam ("video") String video){
        chefProfile.setUser(userSvc.currentUser());
        chefProfile.setVideo(video);
        chefRepo.save(chefProfile);
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
        User user = userSvc.currentUser();

        if(userSvc.isOwner()){
            model.addAttribute("noPicture", restSvc.hasPicture(user));
            model.addAttribute("isOwner", true);
            model.addAttribute("rest", restRepo.findFirstByUser(user));
            model.addAttribute("jobs", jobPostRepo.findByUser(user));
            return"profiles/viewrestprofile";
        }

        else if(!user.isOwner()) {
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
