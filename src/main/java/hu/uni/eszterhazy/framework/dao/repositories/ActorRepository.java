package hu.uni.eszterhazy.framework.dao.repositories;

import hu.uni.eszterhazy.framework.dao.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {

    //@Query("DELETE FROM actor WHERE first_name = :firstName AND last_name=:lastName")
    //int deleteByFirstNameAndLastName(String firstName, String lastName);
}
