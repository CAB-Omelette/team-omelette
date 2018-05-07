package com.codeup.omelette_abc.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "/users/login";
    }
}
