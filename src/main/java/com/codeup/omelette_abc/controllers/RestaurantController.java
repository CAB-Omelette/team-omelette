package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.repositories.RestProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantController {

    private RestProfileRepository restRepo;

    public RestaurantController(RestProfileRepository restRepo){
        this.restRepo = restRepo;
    }

    @GetMapping("/restaurants")
    public String viewAllRestaurants(Model model){
        model.addAttribute("restaurants", restRepo.findAll());
        return"/restaurants/all";
    }

    @GetMapping("/restaurant/{id}")
    public String showRestaurantProfile(@PathVariable long id, Model model){
        model.addAttribute("restaurant", restRepo.findOne(id));
        return "restaurants/view";
    }




}
