package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.repositories.RestProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
