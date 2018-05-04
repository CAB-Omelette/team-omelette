package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.repositories.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SearchController {
    private ChefProfileRepository chefRepo;
    private JobPostRepository jobRepo;
    private RestProfileRepository restRepo;
    private SearchRepository searchRepo;

    public SearchController(ChefProfileRepository chefRepo,
                            JobPostRepository jobRepo,
                            RestProfileRepository restRepo,
                            SearchRepository searchRepo){
        this.searchRepo = searchRepo;
        this.chefRepo = chefRepo;
        this.jobRepo = jobRepo;
        this.restRepo = restRepo;
    }

//    @RequestParam ("selection") String selection

    @GetMapping("/search?searchbar={searchbar}")
    public String search(@RequestParam ("searchbar") String searchbar, Model model) {
        List<ChefProfile> results = searchRepo.findBySearchTermNative(searchbar);
        model.addAttribute(results);
//        ChefProfile chefProfile = new ChefProfile();
//        model.addAttribute("chefs", chefRepo.findAll());
//        model.addAttribute("rest", restRepo.findAll());
//        model.addAttribute("jobs", jobRepo.findAll());
        return "/search";
    }
}




