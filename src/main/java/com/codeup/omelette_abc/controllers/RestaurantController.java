package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantController {

    private RestProfileRepository restRepo;
    private JobPostRepository jobPostRepo;
    private UserService userSvc;

    public RestaurantController(RestProfileRepository restRepo,
                                JobPostRepository jobPostRepo,
                                UserService userSvc){
        this.restRepo = restRepo;
        this.jobPostRepo = jobPostRepo;
        this.userSvc = userSvc;
    }

    public boolean isOwner(){
        return userSvc.currentUser().isOwner() && restRepo.findFirstByUser(userSvc.currentUser()) != null;
    }

    @GetMapping("/restaurants")
    public String viewAllRestaurants(Model model){
        Boolean isOwner = userSvc.currentUser().isOwner();
        model.addAttribute("newJob", new JobListing());
        model.addAttribute("isOwner", isOwner());
        model.addAttribute("restaurants", restRepo.findAll());
        return"/restaurants/all";
    }

    @GetMapping("/restaurant/{id}")
    public String showRestaurantProfile(@PathVariable long id, Model model){
        model.addAttribute("isOwner", isOwner());
        model.addAttribute("rest", restRepo.findOne(id));
        model.addAttribute("newJob", new JobListing());
        if(restRepo.findOne(id).getUser() == userSvc.currentUser()){
            model.addAttribute("restOwns", true);
        }
        User user = restRepo.findOne(id).getUser();
        model.addAttribute("jobs", jobPostRepo.findByUser(user));
        return "restaurants/view";
    }




}
