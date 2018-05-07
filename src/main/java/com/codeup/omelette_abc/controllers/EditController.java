package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.*;
import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.ProfileService;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {


    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
    private ProfileService proSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

    public EditController(ProfileService proSvc,
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



@GetMapping("/edit/profile")
public String editProfile(Model model) {
    Boolean isOwner = userSvc.currentUser().isOwner();
    if(isOwner) {
        model.addAttribute("isOwner", true);
    }
    if (!userSvc.currentUser().isOwner()) {
        ChefProfile chefPro = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chefPro);
        return "/edit/chefprofile";
    }
    RestProfile restPro = restRepo.findFirstByUser(userSvc.currentUser());
    model.addAttribute("rest", restPro);
    return"/edit/restprofile";

}

    @GetMapping("/edit/chefpic")
    public String editChefPic(Model model){
        ChefProfile chef = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chef);
        return"/edit/editchefpicture";
    }

    @GetMapping("/edit/restpic")
    public String editRestPic(Model model){
        model.addAttribute("isOwner", true);
        RestProfile rest = restRepo.findFirstByUser(userSvc.currentUser());
        model.addAttribute("rest", rest);
        return"/edit/editrestpicture";
    }

    @PostMapping("/edit/restaurant")
    public String saveRestEdit(RestProfile restPro, Model model){
        model.addAttribute(restPro);
        restRepo.save(restPro);
        return"redirect:/profile";
    }

    @PostMapping("/edit/chef")
    public String saveChefProfile(ChefProfile chefPro, Model model){
        model.addAttribute(chefPro);
        chefRepo.save(chefPro);
        return"redirect:/profile";
    }

    @GetMapping("/job/{id}/edit")
    public String editJobPost(@PathVariable long id, Model model){
        model.addAttribute("isOwner", true);
        RestProfile rest = restRepo.findFirstByUser(jobPostRepo.findOne(id).getUser());
        JobListing job = jobPostRepo.findOne(id);
        model.addAttribute("job", job);
        return"/edit/jobpost";
    }


    @PostMapping("/edit/job")
    public String saveJobEdit(JobListing job, Model model){
        model.addAttribute("isOwner", true);
        model.addAttribute(job);
        jobPostRepo.save(job);
        return"redirect:/job/" +job.getId();
    }

    @GetMapping("/delete/job/{id}")
    public String deleteJob(@PathVariable long id, Model model){
        model.addAttribute("isOwner", true);
        JobListing job = jobPostRepo.findOne(id);
        jobPostRepo.delete(job);
        return "redirect:/profile";
    }

    @GetMapping("/jobhistory/{id}/edit")
    public String editJobHistory(@PathVariable long id, Model model){
        JobHistory job = jobHistRepo.findOne(id);
        model.addAttribute("job", job);
        return"/edit/jobhistory";
    }


    @PostMapping("/edit/history")
    public String saveJobHistoryEdit(JobHistory job, Model model){
        model.addAttribute(job);
        jobHistRepo.save(job);
        return"redirect:/profile";
    }

    @GetMapping("/education/{id}/edit")
    public String editEducation(@PathVariable long id, Model model){
        Education edu = edRepo.findOne(id);
        model.addAttribute("edu", edu);
        return"/edit/education";
    }

    @PostMapping("/edit/education")
    public String saveEducationEdit(Education edu, Model model){
        model.addAttribute(edu);
        edRepo.save(edu);
        return"redirect:/profile";
    }

    @GetMapping("/edit/{id}/skill")
    public String editSkill(@PathVariable long id, Model model){
        Skills skill = skillsRepo.findOne(id);
        model.addAttribute("skill", skill);
        return"/edit/skills";
    }

    @PostMapping("/edit/skill")
    public String saveSkillEdit(Skills skill, Model model){
        model.addAttribute(skill);
        skillsRepo.save(skill);
        return"redirect:/profile";
    }

    @GetMapping("/delete/skill/{id}")
    public String deleteSkill(@PathVariable long id){
        Skills skill = skillsRepo.findOne(id);
        skillsRepo.delete(skill);
        return "redirect:/profile";
    }

    @GetMapping("/delete/education/{id}")
    public String deleteEducation(@PathVariable long id){
        Education edu = edRepo.findOne(id);
        edRepo.delete(edu);
        return "redirect:/profile";
    }


    @GetMapping("/delete/jobhistory/{id}")
    public String deleteJobHistory(@PathVariable long id){
        JobHistory job = jobHistRepo.findOne(id);
        jobHistRepo.delete(job);
        return "redirect:/profile";
    }


}
