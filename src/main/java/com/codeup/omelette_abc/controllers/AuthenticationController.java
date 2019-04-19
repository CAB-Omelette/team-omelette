package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.models.JobListing;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//notes more notes
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("newJob", new JobListing());
        return "/";
    }
}
