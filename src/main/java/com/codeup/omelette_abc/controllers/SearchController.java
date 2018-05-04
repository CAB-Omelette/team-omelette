package com.codeup.omelette_abc.controllers;

import com.codeup.omelette_abc.repositories.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SearchController {
    private SearchRepository searchRepo;

        public SearchController(){
        }


    public SearchController(SearchRepository searchRepo){
        this.searchRepo = searchRepo;
    }
        @GetMapping("/search")
        public String search() {
            return "/search";
        }


    }




