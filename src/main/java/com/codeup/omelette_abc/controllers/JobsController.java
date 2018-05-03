package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.services.JobsService;
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

    public JobsController(RestProfileRepository restRepo,
                          JobsService jobSvc,
                          JobPostRepository jobsRepo,
                          UserService userSvc){
        this.restRepo = restRepo;
        this.jobSvc = jobSvc;
        this.jobsRepo = jobsRepo;
        this.userSvc = userSvc;
    }



    @GetMapping("/jobs/create")
    public String createNewJob(Model model){
        model.addAttribute("newJob", new JobListing());
        return "/jobs/create";
    }

    @PostMapping("/jobs/create")
    public String postJob(@ModelAttribute JobListing newJob){
        newJob.setUser(userSvc.currentUser());
        jobsRepo.save(newJob);
        return"redirect:/job/" + newJob.getId();
    }


    @GetMapping("/job/{id}")
    public String viewJob(@PathVariable Long id, Model model){
        JobListing job = jobsRepo.findOne(id);
        RestProfile rest = restRepo.findFirstByUser(job.getUser());
        job.setRest(rest);
        model.addAttribute("job", job);
        return "jobs/view";
    }

    @GetMapping(value = "/all")
    public String viewAllJobPosts(Model model) {
        Iterable<JobListing> jobs = jobsRepo.findAll();
        for (JobListing job: jobs) {
            job.setRest(restRepo.findFirstByUser(job.getUser()));
        }
        model.addAttribute("jobs", jobs);
        return "jobs/all";
    }


}