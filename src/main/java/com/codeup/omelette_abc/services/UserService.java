package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public boolean isLoggedIn(){
        if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken){
            return false;
        }
        return true;
    }
    public User currentUser(){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
