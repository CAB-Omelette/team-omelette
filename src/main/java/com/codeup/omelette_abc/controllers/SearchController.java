package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchController {
    private ChefProfileRepository chefRepo;
    private JobPostRepository jobRepo;
    private RestProfileRepository restRepo;
    private SkillsRepository skillsRepo;


    public SearchController(ChefProfileRepository chefRepo,
                            JobPostRepository jobRepo,
                            RestProfileRepository restRepo,
                            SkillsRepository skillsRepo){
        this.chefRepo = chefRepo;
        this.jobRepo = jobRepo;
        this.restRepo = restRepo;
        this.skillsRepo = skillsRepo;
    }

//    @RequestParam ("selection") String selection

    @GetMapping("/search/results")
    public String search(@RequestParam ("searchTerm") String searchTerm, Model model) {
//        model.addAttribute("chefs", chefRepo.findBySearchTerm(searchTerm));
//        model.addAttribute("jobs", jobRepo.findBySearchTerm(searchTerm));
//        model.addAttribute("rests", restRepo.findBySearchTerm(searchTerm));
//        model.addAttribute("skills", skillsRepo.findBySearchTerm(searchTerm));
        return "/search/searchResults";
    }
}

//
//    private final ChefProfileRepository chefProfileRepository;
//    private final JobPostRepository jobPostRepository;
//    private final RestProfileRepository restProfileRepository;
//    private final SkillsRepository skillsRepository;
//
//    public SearchController(ChefProfileRepository chefProfileRepository,
//                            JobPostRepository jobPostRepository,
//                            RestProfileRepository restProfileRepository,
//                            SkillsRepository skillsRepository) {
//        this.chefProfileRepository = chefProfileRepository;
//        this.jobPostRepository = jobPostRepository;
//        this.restProfileRepository = restProfileRepository;
//        this.skillsRepository = skillsRepository;
//    }
//
//    @GetMapping("/search/results")
//    public String showSearchResults(Model model, @RequestParam(name = "searchTerm") String search,
//                                    @RequestParam(name = "searchChefs") String cp,
//                                    @RequestParam(name = "searchRests") String rr,
//                                    @RequestParam(name = "searchJobs") String jr,
//                                    @RequestParam(name = "searchSkills") String sk){
//            model.addAttribute("chefs", chefProfileRepository.findBySearchTerm(search));
//            model.addAttribute("rests", restProfileRepository.findBySearchTerm(search));
//            model.addAttribute("jobs", jobPostRepository.findBySearchTerm(search));
//            model.addAttribute("skills", skillsRepository.findBySearchTerm(search));
//
//        return "/search/searchResults";
//    }
//}


