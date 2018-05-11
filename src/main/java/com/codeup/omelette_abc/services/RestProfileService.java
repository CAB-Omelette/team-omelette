package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import org.springframework.stereotype.Service;
@Service
public class RestProfileService {

    private RestProfileRepository restRepo;
    private UserService userSvc;

    public RestProfileService(RestProfileRepository restRepo,UserService userSvc){
        this.restRepo = restRepo;
        this.userSvc = userSvc;
    }

    public boolean hasPicture(User user){
        return restRepo.findFirstByUser(user).getPicture() == null ||
                restRepo.findFirstByUser(user).getPicture().equals("");
    }

    public boolean hasProfile(){
        return restRepo.findFirstByUser(userSvc.currentUser()) == null;
    }

}
