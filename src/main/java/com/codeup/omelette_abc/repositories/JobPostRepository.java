package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends CrudRepository<JobListing, Long> {

    Iterable<JobListing> findByUser(User user);

    Iterable<JobListing> findAll();

    Integer countByUser(User user);



}
