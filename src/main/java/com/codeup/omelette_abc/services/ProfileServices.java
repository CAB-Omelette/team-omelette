package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileServices {

    private ChefProfileRepository chefProRepo;
    private RestProfileRepository restRepo;

    public ProfileServices(ChefProfileRepository chefProRepo,
                           RestProfileRepository restRepo){
        this.chefProRepo = chefProRepo;
        this.restRepo = restRepo;
    }

    public boolean hasChefProfile(User user){
        if(chefProRepo.findByUser(user) == null){
            return false;
        }
        return true;
    }

    public boolean hasRestProfile(User user){
        if(restRepo.findFirstByUser(user) == null){
            return false;
        }
        return true;
    }
}


