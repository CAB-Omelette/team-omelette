package com.codeup.omelette_abc.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        Authentication token = SecurityContextHolder.getContext().getAuthentication();
        if (token instanceof AnonymousAuthenticationToken) return "login";
        return String.format("redirect:%s", "/");
    }
}
