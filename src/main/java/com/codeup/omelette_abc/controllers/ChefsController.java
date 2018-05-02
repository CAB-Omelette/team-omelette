package com.codeup.omelette_abc.controllers;


import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChefsController {

    private ChefProfileRepository chefRepo;

    public ChefsController(ChefProfileRepository chefRepo) {
        this.chefRepo = chefRepo;
    }


    @GetMapping("/chefs")
    public String viewAllChefs(Model model) {
        model.addAttribute("chefs", chefRepo.findAll());
        return "/chefs/all";
    }

}
