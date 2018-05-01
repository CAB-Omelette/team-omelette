package com.codeup.omelette_abc.repositories;


import com.codeup.omelette_abc.models.ChefProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefProfileRepository extends CrudRepository<ChefProfile, Long>{


    @Query(value = "SELECT * FROM CHEF_PROFILE WHERE user_id = :id", nativeQuery = true)
    ChefProfile findByUserId(@Param("id") long id);
}
