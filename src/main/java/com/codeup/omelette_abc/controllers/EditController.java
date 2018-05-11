package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.*;
import com.codeup.omelette_abc.repositories.*;
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
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

    public EditController(
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



@GetMapping("/edit/profile")
public String editProfile(Model model) {
        model.addAttribute("isOwner", userSvc.isOwner());
    if (!userSvc.isOwner()) {
        model.addAttribute("newJob", new JobListing());
        ChefProfile chefPro = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chefPro);
        return "/edit/chefprofile";
    }
    RestProfile restPro = restRepo.findFirstByUser(userSvc.currentUser());
    model.addAttribute("isOwner", isOwner());
    model.addAttribute("rest", restPro);
    model.addAttribute("newJob", new JobListing());
    return"/edit/restprofile";

}

    @GetMapping("/edit/chefpic")
    public String editChefPic(Model model){
        ChefProfile chef = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chef);
        model.addAttribute("newJob", new JobListing());
        return"/edit/editchefpicture";
    }

    @GetMapping("/edit/restpic")
    public String editRestPic(Model model){
        model.addAttribute("isOwner", isOwner());
        RestProfile rest = restRepo.findFirstByUser(userSvc.currentUser());
        model.addAttribute("rest", rest);
        model.addAttribute("newJob", new JobListing());
        return"/edit/editrestpicture";
    }

    @PostMapping("/edit/restaurant")
    public String saveRestEdit(RestProfile restPro, Model model){
        model.addAttribute(restPro);
        restRepo.save(restPro);
        model.addAttribute("newJob", new JobListing());
        return"redirect:/profile";
    }

    @PostMapping("/edit/chef")
    public String saveChefProfile(ChefProfile chefPro, Model model){
        model.addAttribute(chefPro);
        chefRepo.save(chefPro);
        model.addAttribute("newJob", new JobListing());
        return"redirect:/profile";
    }

    @GetMapping("/job/{id}/edit")
    public String editJobPost(@PathVariable long id, Model model){
        model.addAttribute("isOwner", isOwner());
        RestProfile rest = restRepo.findFirstByUser(jobPostRepo.findOne(id).getUser());
        JobListing job = jobPostRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("job", job);
        return"/edit/jobpost";
    }


    @PostMapping("/edit/job")
    public String saveJobEdit(JobListing job, Model model){
        model.addAttribute("isOwner", isOwner());
        model.addAttribute(job);
        model.addAttribute("newJob", new JobListing());
        jobPostRepo.save(job);
        return"redirect:/job/" +job.getId();
    }

    @GetMapping("/delete/job/{id}")
    public String deleteJob(@PathVariable long id, Model model){
        model.addAttribute("isOwner", isOwner());
        JobListing job = jobPostRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        jobPostRepo.delete(job);
        return "redirect:/profile";
    }

    @GetMapping("/jobhistory/{id}/edit")
    public String editJobHistory(@PathVariable long id, Model model){
        JobHistory job = jobHistRepo.findOne(id);
        model.addAttribute("job", job);
        model.addAttribute("newJob", new JobListing());
        return"/edit/jobhistory";
    }


    @PostMapping("/edit/history")
    public String saveJobHistoryEdit(JobHistory job, Model model){
        model.addAttribute(job);
        model.addAttribute("newJob", new JobListing());
        jobHistRepo.save(job);

        return"redirect:/profile";
    }

    @GetMapping("/education/{id}/edit")
    public String editEducation(@PathVariable long id, Model model){
        Education edu = edRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("edu", edu);
        return"/edit/education";
    }

    @PostMapping("/edit/education")
    public String saveEducationEdit(Education edu, Model model){
        model.addAttribute(edu);
        model.addAttribute("newJob", new JobListing());
        edRepo.save(edu);
        return"redirect:/profile";
    }

    @GetMapping("/edit/{id}/skill")
    public String editSkill(@PathVariable long id, Model model){
        Skills skill = skillsRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("skill", skill);
        return"/edit/skills";
    }

    @PostMapping("/edit/skill")
    public String saveSkillEdit(Skills skill, Model model){
        model.addAttribute(skill);
        model.addAttribute("newJob", new JobListing());
        skillsRepo.save(skill);
        return"redirect:/profile";
    }

    @GetMapping("/delete/skill/{id}")
    public String deleteSkill(@PathVariable long id, Model model){
        Skills skill = skillsRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        skillsRepo.delete(skill);
        return "redirect:/profile";
    }

    @GetMapping("/delete/education/{id}")
    public String deleteEducation(@PathVariable long id, Model model){
        Education edu = edRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        edRepo.delete(edu);
        return "redirect:/profile";
    }


    @GetMapping("/delete/jobhistory/{id}")
    public String deleteJobHistory(@PathVariable long id, Model model){
        JobHistory job = jobHistRepo.findOne(id);
        model.addAttribute("newJob", new JobListing());
        jobHistRepo.delete(job);
        return "redirect:/profile";
    }


}
