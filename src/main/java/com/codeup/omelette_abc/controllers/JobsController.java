package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.services.JobsService;
import com.codeup.omelette_abc.services.RestProfileService;
import com.codeup.omelette_abc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class JobsController {

    private RestProfileRepository restRepo;
    private JobsService jobSvc;
    private JobListing jobList;
    private JobPostRepository jobsRepo;
    private UserService userSvc;
    private RestProfileService restSvc;

    public JobsController(RestProfileRepository restRepo,
                          JobsService jobSvc,
                          JobPostRepository jobsRepo,
                          UserService userSvc,
                          RestProfileService restSvc){
        this.restRepo = restRepo;
        this.jobSvc = jobSvc;
        this.jobsRepo = jobsRepo;
        this.userSvc = userSvc;
        this.restSvc = restSvc;
    }

    public boolean isOwner(){
        return userSvc.currentUser().isOwner();
    }

    @GetMapping("/jobs/create")
    public String createNewJob(Model model){
            model.addAttribute("isOwner", isOwner());
        if(restRepo.findFirstByUser(userSvc.currentUser()) != null) {
            model.addAttribute("newJob", new JobListing());
            model.addAttribute("isOwner", true);
            return "/jobs/create";
        }
        return"redirect:/createprofile";
    }

    @PostMapping("/jobs/create")
    public String postJob(@ModelAttribute JobListing newJob, Model model){
        model.addAttribute("isOwner", isOwner());
        newJob.setUser(userSvc.currentUser());
        jobsRepo.save(newJob);
        return"redirect:/job/" + newJob.getId();
    }

    @GetMapping("/job/{id}")
    public String viewJob(@PathVariable Long id, Model model){
        model.addAttribute("isOwner", isOwner());
        JobListing job = jobsRepo.findOne(id);
        RestProfile rest = restRepo.findFirstByUser(job.getUser());
        job.setRest(rest);
        model.addAttribute("job", job);
        return "jobs/view";
    }

    @GetMapping(value = "/all")
    public String viewAllJobPosts(Model model) {
        model.addAttribute("isOwner", isOwner());
        Iterable<JobListing> jobs = jobsRepo.findAll();
        for (JobListing job: jobs) {
            job.setRest(restRepo.findFirstByUser(job.getUser()));
        }
        model.addAttribute("jobs", jobs);
        return "jobs/all";
    }




}