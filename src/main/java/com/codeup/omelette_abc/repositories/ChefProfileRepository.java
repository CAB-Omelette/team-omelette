package com.codeup.omelette_abc.repositories;


import com.codeup.omelette_abc.models.ChefProfile;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ChefProfileRepository extends CrudRepository<ChefProfile, Long>{

    ChefProfile findByUser(User user);

    List<ChefProfile> findByFirstNameLike(String str);

    int countByIdAndVideoNotNull(Long id);

    List<ChefProfile> findAll();



}

