package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.repositories.SearchRepository;
import org.springframework.stereotype.Controller;


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


//    @GetMapping("/search")
//    public String search(@RequestParam ("search") String search, Model model) {
//        List<ChefProfile> results = chefRepo.findByfirst_nameLike(search);
//        model.addAttribute("results",results);
//        return "/search";
//    }
}




