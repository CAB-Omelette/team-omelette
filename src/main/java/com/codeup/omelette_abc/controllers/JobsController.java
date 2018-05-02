package com.codeup.omelette_abc.controllers;



import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import com.codeup.omelette_abc.services.JobsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class JobsController {


    private RestProfileRepository restRepo;
    private JobsService jobSvc;
    private JobListing jobList;
    private JobPostRepository jobsRepo;

    public JobsController(RestProfileRepository restRepo, JobsService jobSvc,  JobPostRepository jobsRepo){
        this.restRepo = restRepo;
        this.jobSvc = jobSvc;
        this.jobsRepo = jobsRepo;
    }



    @GetMapping(value= "/job_post/create")
    public String createNewJob(Model model){
        model.addAttribute("newJob", new JobListing());
        return "jobs/job_post_form";
    }



    @PostMapping(value = "/job_post/{id}")
    public String saveNewJob(@ModelAttribute JobListing newJob){
        newJob.setTitle(newJob.getTitle());
        newJob.setDescription(newJob.getDescription());
        newJob.setPay(newJob.getPay());
        jobsRepo.save(newJob);
        return "jobs/job_post_list";
    }



    @GetMapping(value = "/job_post/{id}")
    public String viewJobPost(@PathVariable Long id, Model model) {
        JobListing job = jobsRepo.findOne(id);
        RestProfile rest = restRepo.findByUser(job.getUser());
        model.addAttribute("rest", rest);
        model.addAttribute("job", job);
        return "jobs/job_post";
    }

    @GetMapping(value = "/job_post_list")
    public String viewAllJobPosts(Model model) {
        model.addAttribute("rest", restRepo.findByUser(jobList.getUser()));
        model.addAttribute("jobs", jobsRepo.findAll());
        return "jobs/job_post_list";
    }


}