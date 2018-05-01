package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.Education;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {

    @Query(value = "SELECT * FROM education WHERE user_id = :id", nativeQuery = true)
    Iterable<Education> findByUserId(@Param("id") long id);
}
