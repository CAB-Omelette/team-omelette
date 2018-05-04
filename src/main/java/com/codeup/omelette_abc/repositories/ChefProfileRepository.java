package com.codeup.omelette_abc.repositories;


import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
public interface ChefProfileRepository extends CrudRepository<ChefProfile, Long>{

    ChefProfile findByUser(User user);

    ChefProfile findBy(Table chef_profile);


}
