package com.codeup.omelette_abc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @GetMapping("/createchefprofile")
    public String createChefProfile(){
        return "newuser/newchefprofile";
    }

    @GetMapping("/createrestprofile")
    public String createRestProfile(){
        return "newuser/newrestprofile";
    }



}
