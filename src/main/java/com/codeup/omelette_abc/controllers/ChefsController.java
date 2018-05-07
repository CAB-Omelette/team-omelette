package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.ProfileServices;
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
    private ProfileServices proSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private UsersRepository usersRepo;

    public ChefsController(ProfileServices proSvc,
                             UsersRepository usersRepo,
                             ChefProfileRepository chefRepo,
                             UserService userSvc,
                             RestProfileRepository restRepo,
                             JobHistoryRepository jobHistRepo,
                             EducationRepository edRepo,
                             SkillsRepository skillsRepo) {
        this.proSvc = proSvc;
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
        this.usersRepo = usersRepo;
    }

    public boolean isOwner(){
        return userSvc.currentUser().isOwner();
    }

    public boolean hasJobs(Long id){
        return jobHistRepo.findByUser(chefRepo.findOne(id).getUser()) == null;
    }

    public boolean hasEdu(Long id){
        return edRepo.findByUser(chefRepo.findOne(id).getUser()) != null;
    }

    @GetMapping("/chefs")
    public String viewAllChefs(Model model) {
        if(isOwner()) {
            model.addAttribute("isOwner", true);
        }
        model.addAttribute("chefs", chefRepo.findAll());
        return "/chefs/all";
    }

    @GetMapping("/chefs/{id}")
    public String viewAllChefs(@PathVariable Long id, Model model) {
        User thisChef = chefRepo.findOne(id).getUser();

        if(isOwner()) {
            model.addAttribute("isOwner", true);
        }

        if(hasJobs(id)){
            model.addAttribute("hasJobs", true);
        }

        if(hasEdu(id)){
            model.addAttribute("hasEdu", true);
        }

        System.out.println(hasJobs(id));
        System.out.println(hasEdu(id));

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
