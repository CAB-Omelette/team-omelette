package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.JobHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends CrudRepository<JobHistory, Long> {


    @Query(value = "SELECT * FROM job_history WHERE user_id = :id", nativeQuery = true)
    Iterable<JobHistory> findByUserId(@Param("id") long id);

}
