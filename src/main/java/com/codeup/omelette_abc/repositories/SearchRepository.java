package com.codeup.omelette_abc.repositories;

import com.codeup.omelette_abc.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;


@Repository
public interface SearchRepository  {

    @Async
    ListenableFuture<ChefProfile> findChefFirstName(String first_name);

    @Async
    ListenableFuture<ChefProfile> findChefLastName(String last_name);

    @Async
    ListenableFuture<JobListing> findByJobTitle(String title);

    @Async
    ListenableFuture<JobListing> findByPay(String pay);

    @Async
    ListenableFuture<RestProfile> findByRestName(String name);

    @Async
    ListenableFuture<RestProfile> findByRestCity(String city);

    @Async
    ListenableFuture<RestProfile> findByRestState(String state);

    @Async
    ListenableFuture<RestProfile> findByRestZip(String zip);

    @Async
    ListenableFuture<Skills> findBySkill (String name);






}