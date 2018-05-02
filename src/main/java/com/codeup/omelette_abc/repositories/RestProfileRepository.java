package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestProfileRepository extends CrudRepository<RestProfile, Long> {

    RestProfile findByUser(User user);


//    @Query(value = "SELECT * FROM REST_PROFILE WHERE user_id = :id", nativeQuery = true)
//    RestProfile findByUserId(@Param("id") long id);
}

