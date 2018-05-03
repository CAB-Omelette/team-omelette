package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.*;
import com.codeup.omelette_abc.services.ProfileServices;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {


    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
    private ProfileServices proSvc;
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

    public EditController(ProfileServices proSvc,
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
    if (!userSvc.currentUser().isOwner()) {
        ChefProfile chefPro = chefRepo.findByUser(userSvc.currentUser());
        model.addAttribute("chef", chefPro);
        return "/edit/chefprofile";
    }
    RestProfile restPro = restRepo.findByUser(userSvc.currentUser());
    model.addAttribute("rest", restPro);
    return"/edit/restprofile";

}

@PostMapping("/edit/restaurant")
    public String saveRestEdit(RestProfile restPro, Model model){
        model.addAttribute(restPro);
        restRepo.save(restPro);
        return"/profile";
}


}
