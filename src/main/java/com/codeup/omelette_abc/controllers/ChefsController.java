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

    public ChefsController(ProfileServices proSvc,
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
    }

    @GetMapping("/chefs")
    public String viewAllChefs(Model model) {
        model.addAttribute("chefs", chefRepo.findAll());
        return "/chefs/all";
    }

    @GetMapping("/chefs/{id}")
    public String viewAllChefs(@PathVariable Long id, Model model) {
        ChefProfile chefId = chefRepo.findOne(id);
        User chef = chefId.getUser();
        model.addAttribute("user", chef);
        model.addAttribute("chef", chefRepo.findOne(id));
        model.addAttribute("jobs", jobHistRepo.findByUser(chef));
        model.addAttribute("education", edRepo.findByUser(chef));
        model.addAttribute("skills", skillsRepo.findByUser(chef));
        return "/chefs/view";
    }

}
