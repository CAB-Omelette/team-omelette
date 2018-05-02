package com.codeup.omelette_abc.repositories;


import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefProfileRepository extends CrudRepository<ChefProfile, Long>{

    ChefProfile findByUser(User user);

}
