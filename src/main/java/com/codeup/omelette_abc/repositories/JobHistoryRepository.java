package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.JobHistory;
import org.springframework.data.repository.CrudRepository;

public interface JobHistoryRepository extends CrudRepository<JobHistory, Long> {
}
