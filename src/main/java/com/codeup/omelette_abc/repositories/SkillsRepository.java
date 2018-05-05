package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.Skills;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepository extends CrudRepository<Skills, Long> {

    Iterable<Skills> findByUser(User user);



}
