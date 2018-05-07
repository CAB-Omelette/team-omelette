package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.repositories.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        search = "%"+search+"%";
        List<ChefProfile> chefResults = chefRepo.findByFirstNameLike(search);
        List<RestProfile> restResults = restRepo.findByNameIsLike(search);

        model.addAttribute("chefResults",chefResults);
        model.addAttribute("restResults", restResults);
        return "/partials/search";
    }
}




