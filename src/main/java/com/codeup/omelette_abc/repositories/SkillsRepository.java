package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.Skills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepository extends CrudRepository<Skills, Long> {

    @Query(value = "SELECT * FROM skills WHERE user_id = :id", nativeQuery = true)
    Iterable<Skills> findByUserId(@Param("id") long id);
}
