package com.codeup.omelette_abc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/index")
    public String showIndex(){
        return("/index");
    }

    @GetMapping("/")
    public String showHome(){
        return("/index");
    }


}
