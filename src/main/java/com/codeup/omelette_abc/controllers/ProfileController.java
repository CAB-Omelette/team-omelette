package com.codeup.omelette_abc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/createprofile")
    public String createChefProfile(){
        return "newuser/newchefprofile";
    }


}
