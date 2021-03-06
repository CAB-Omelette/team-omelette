package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChefsController {

    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private UsersRepository usersRepo;

    public ChefsController(
                             UsersRepository usersRepo,
                             ChefProfileRepository chefRepo,
                             UserService userSvc,
                             RestProfileRepository restRepo,
                             JobHistoryRepository jobHistRepo,
                             EducationRepository edRepo,
                             SkillsRepository skillsRepo) {
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
        this.usersRepo = usersRepo;
    }

    public boolean hasJobs(Long id){ return jobHistRepo.countByUser(chefRepo.findOne(id).getUser()) >0; }

    public boolean hasEdu(Long id){
        return edRepo.countByUser(chefRepo.findOne(id).getUser()) >0;
    }

    public boolean hasSkills(Long id){
        return skillsRepo.countByUser(chefRepo.findOne(id).getUser()) >0;
    }

    public boolean hasVideo(Long id){
       return chefRepo.countByIdAndVideoNotNull(id)>0;
    }

    public boolean isOwner(){
        return userSvc.currentUser().isOwner() && restRepo.findFirstByUser(userSvc.currentUser()) != null;
    }

    @GetMapping("/chefs")
    public String viewAllChefs(Model model) {
        model.addAttribute("isOwner", isOwner());
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("chefs", chefRepo.findAll());
        return "/chefs/all";
    }


    @GetMapping("/chefs/{id}")
    public String viewAllChefs(@PathVariable Long id, Model model) {
        model.addAttribute("newJob", new JobListing());
        if(chefRepo.countByIdAndVideoNotNull(id) != 0 || !chefRepo.findOne(id).getVideo().equals("")){
            model.addAttribute("hasVideo", true);
        }
            model.addAttribute("isOwner", isOwner());
            model.addAttribute("hasJobs", hasJobs(id));
            model.addAttribute("hasEdu", hasEdu(id));
            model.addAttribute("hasSkills", hasSkills(id));
            if(chefRepo.findOne(id).getUser() == userSvc.currentUser()){
                model.addAttribute("chefOwns", true);
            }
            ChefProfile chefId = chefRepo.findOne(id);
            User chef = chefId.getUser();

        if(edRepo.findByUser(chef) != null){
            model.addAttribute("hasEducation", true);
            model.addAttribute("education", edRepo.findByUser(chef));
        }
        model.addAttribute("user", chef);
        model.addAttribute("chef", chefRepo.findOne(id));
        model.addAttribute("jobs", jobHistRepo.findByUser(chef));
        model.addAttribute("skills", skillsRepo.findByUser(chef));
        return "/chefs/view";
    }

}
