package hu.uni.eszterhazy.framework.dao.repositories;

import hu.uni.eszterhazy.framework.dao.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

    Optional<LanguageEntity> findByName(String name);
}
