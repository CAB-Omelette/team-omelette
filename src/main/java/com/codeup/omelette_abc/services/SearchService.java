package com.codeup.omelette_abc.services;


import com.codeup.omelette_abc.repositories.SearchRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private SearchRepository searchRepo;

    public SearchService(SearchRepository searchRepo){
        this.searchRepo = searchRepo;
    }

    public SearchService(){
    }



}
