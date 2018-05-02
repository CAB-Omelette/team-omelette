package com.codeup.omelette_abc.controllers;



import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class JobsController {

    private JobPostRepository jobs;

    @GetMapping(value= "/job_post/create")
    public String createNewJob(Model model){
        model.addAttribute("newJob", new JobListing());
        return "/job_post_form";
    }

    @PostMapping(value = "/job_post/{id}")
    public String saveNewJob(){

    }


    @RequestMapping(value = "/job_post/{id}", method = RequestMethod.GET)
    public String getJobPostFormPage(@PathVariable Long id) {
        return "/job_post_form";
    }

    @RequestMapping(value = "/job_post", method = RequestMethod.GET)
    public String getJobPostListPage() {
        return "/job_post_list";
    }
}