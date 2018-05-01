package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.JobHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends CrudRepository<JobHistory, Long> {
}
