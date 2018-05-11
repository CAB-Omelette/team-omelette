package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends CrudRepository<JobListing, Long> {

    Iterable<JobListing> findByUser(User user);

    Iterable<JobListing> findAll();

    Integer countByUser(User user);

    List<JobListing> findByTitleIsLike(String str);

}
