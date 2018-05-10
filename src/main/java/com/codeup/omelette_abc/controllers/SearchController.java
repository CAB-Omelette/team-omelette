package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.repositories.SearchRepository;
import com.codeup.omelette_abc.services.UserService;
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
    private UserService userSvc;

    public SearchController(ChefProfileRepository chefRepo,
                            JobPostRepository jobRepo,
                            RestProfileRepository restRepo,
                            SearchRepository searchRepo,
                            UserService userSvc){
        this.searchRepo = searchRepo;
        this.chefRepo = chefRepo;
        this.jobRepo = jobRepo;
        this.restRepo = restRepo;
        this.userSvc = userSvc;
    }

    public boolean isOwner(){
        return userSvc.currentUser().isOwner() && restRepo.findFirstByUser(userSvc.currentUser()) != null;
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        if(search.equals("")){
            return "redirect:/";
        }
        search = "%"+search+"%";
        List<ChefProfile> chefResults = chefRepo.findByFirstNameLike(search);
        List<RestProfile> restResults = restRepo.findByNameIsLike(search);
        List<RestProfile> cityResults = restRepo.findByCityIsLike(search);
        List<JobListing> jobResults = jobRepo.findByTitleIsLike(search);
        model.addAttribute("isOwner", isOwner());
        model.addAttribute("chefResults",chefResults);
        model.addAttribute("restResults", restResults);
        model.addAttribute("jobResults", jobResults);
        model.addAttribute("cityResults", cityResults);

        for (JobListing job: jobResults) {
            job.setRest(restRepo.findFirstByUser(job.getUser()));
        }
        model.addAttribute("newJob", new JobListing());
        return "/partials/search";
    }
}




