package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.Education;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {

    Iterable<Education> findByUser(User user);

    Integer countByUser(User user);

}
