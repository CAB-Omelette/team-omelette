package com.codeup.omelette_abc.controllers;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class JobsController {


    @RequestMapping(value = "/job_post/create", method = RequestMethod.GET)
    public String getJobPostFormPage() {
        return "/job_post_form";
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