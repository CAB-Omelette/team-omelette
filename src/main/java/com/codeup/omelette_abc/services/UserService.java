package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.UsersRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private UsersRepository userRepo;

    public UserService(UsersRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean isLoggedIn(){
        if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken){
            return false;
        }
        return true;
    }
    public User currentUser(){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepo.findOne(user.getId());
    }



}
