package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestProfileRepository extends CrudRepository<RestProfile, Long> {

    RestProfile findByUser(User user);

}

