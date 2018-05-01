package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {
}
