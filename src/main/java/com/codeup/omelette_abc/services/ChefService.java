package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.models.User;
import com.codeup.omelette_abc.repositories.ChefProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

    private ChefProfileRepository chefRepo;
    private UserService userSvc;

    public ChefService(ChefProfileRepository chefRepo, UserService userSvc){
        this.chefRepo = chefRepo;
        this.userSvc = userSvc;
    }

    public boolean hasPicture(User user){
        return chefRepo.findByUser(user).getPicture() == null ||
                chefRepo.findByUser(user).getPicture().equals("");
    }

    public boolean hasVideo(Long id){
        return chefRepo.countByIdAndVideoNotNull(id)>0;
    }

    public boolean hasProfile(){
        return chefRepo.findByUser(userSvc.currentUser()) == null;
    }

}
