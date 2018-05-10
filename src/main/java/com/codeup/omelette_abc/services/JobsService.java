package com.codeup.omelette_abc.services;

import com.codeup.omelette_abc.models.JobListing;
import com.codeup.omelette_abc.repositories.JobPostRepository;
import com.codeup.omelette_abc.repositories.RestProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {

    private JobPostRepository jobsRepo;
    private RestProfileRepository restRepo;

    public JobsService(JobPostRepository jobsRepo, RestProfileRepository restRepo) {
        this.jobsRepo = jobsRepo;
        this.restRepo = restRepo;
    }

//    public Iterable JobsWithLocation(){
//        Iterable<JobListing> results = jobsRepo.findAll();
//        for (JobListing job: results) {
//            job.setRest(restRepo.findFirstByUser(job.getUser()));
//        }
//        return results;
//    }


}
