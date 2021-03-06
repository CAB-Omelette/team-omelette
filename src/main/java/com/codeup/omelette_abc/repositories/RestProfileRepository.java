package com.codeup.omelette_abc.repositories;
import com.codeup.omelette_abc.models.RestProfile;
import com.codeup.omelette_abc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestProfileRepository extends CrudRepository<RestProfile, Long> {

    RestProfile findFirstByUser(User user);

    List<RestProfile> findByNameIsLike(String str);

    List<RestProfile> findByStateLike(String str);

    List<RestProfile> findByCityIsLike(String str);

}

