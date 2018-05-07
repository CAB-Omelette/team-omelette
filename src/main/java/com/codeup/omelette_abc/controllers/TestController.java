package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.*;
<<<<<<< HEAD
import com.codeup.omelette_abc.services.ProfileService;
=======
>>>>>>> 06ac08daf94c45428609758fef68b074520a197f
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private ChefProfileRepository chefRepo;
    private RestProfileRepository restRepo;
    private UserService userSvc;
<<<<<<< HEAD
    private ProfileService proSvc;
=======
>>>>>>> 06ac08daf94c45428609758fef68b074520a197f
    private JobHistoryRepository jobHistRepo;
    private EducationRepository edRepo;
    private SkillsRepository skillsRepo;
    private JobPostRepository jobPostRepo;

<<<<<<< HEAD
    public TestController(ProfileService proSvc,
                          ChefProfileRepository chefRepo,
                          UserService userSvc,
                          RestProfileRepository restRepo,
                          JobHistoryRepository jobHistRepo,
                          EducationRepository edRepo,
                          SkillsRepository skillsRepo,
                          JobPostRepository jobPostRepo) {
        this.proSvc = proSvc;
=======
    public TestController(
                             ChefProfileRepository chefRepo,
                             UserService userSvc,
                             RestProfileRepository restRepo,
                             JobHistoryRepository jobHistRepo,
                             EducationRepository edRepo,
                             SkillsRepository skillsRepo,
                             JobPostRepository jobPostRepo) {
>>>>>>> 06ac08daf94c45428609758fef68b074520a197f
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
        this.restRepo = restRepo;
        this.jobHistRepo = jobHistRepo;
        this.edRepo = edRepo;
        this.skillsRepo = skillsRepo;
        this.jobPostRepo = jobPostRepo;
    }



    @GetMapping("/")
    public String showIndex(Model model) {
        if(userSvc.isLoggedIn()){
            model.addAttribute("loggedIn", true);
        }
        return "/index";
    }

    @GetMapping("/loggedin")
    public String loggedIn(Model model) {
        model.addAttribute("loggedIn", true);
        User user = userSvc.currentUser();
        if(user.isOwner()) {
            model.addAttribute("isOwner", true);
        }
        if(restRepo.findFirstByUser(user) != null){
            return"redirect:/";
        }
        if(chefRepo.findByUser(user) != null){
            return"redirect:/";
        }
        return "/index";
    }


}

