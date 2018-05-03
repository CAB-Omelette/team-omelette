package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantController {

    private RestProfileRepository restRepo;
    private JobPostRepository jobPostRepo;

    public RestaurantController(RestProfileRepository restRepo,
                                JobPostRepository jobPostRepo){
        this.restRepo = restRepo;
        this.jobPostRepo = jobPostRepo;
    }

    @GetMapping("/restaurants")
    public String viewAllRestaurants(Model model){
        model.addAttribute("restaurants", restRepo.findAll());
        return"/restaurants/all";
    }

    @GetMapping("/restaurant/{id}")
    public String showRestaurantProfile(@PathVariable long id, Model model){
        model.addAttribute("rest", restRepo.findOne(id));
        User user = restRepo.findOne(id).getUser();
        model.addAttribute("jobs", jobPostRepo.findByUser(user));
        return "restaurants/view";
    }




}
