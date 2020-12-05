package hu.uni.eszterhazy.framework.dao.repositories;

import hu.uni.eszterhazy.framework.dao.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
}
