package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SearchRepository extends CrudRepository<ChefProfile, Long>  {


    @Query(value = "SELECT * FROM chef_profile cp WHERE " +
            "LOWER(cp.first_name) LIKE LOWER(CONCAT('%',:searchbar, '%'))" +
            " OR " +
            "LOWER(cp.last_name) LIKE LOWER(CONCAT('%',:searchbar, '%'))",
            nativeQuery = true
    )
    List<ChefProfile> findBySearchTermNative(@Param("searchbar") String searchbar);



}
