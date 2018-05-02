package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.repositories.JobPostRepository;
import org.springframework.stereotype.Service;

@Service
public class JobsService {

    private JobPostRepository jobsRepo;

    public JobsService(JobPostRepository jobsRepo) {
        this.jobsRepo = jobsRepo;
    }




}
