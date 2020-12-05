package hu.uni.eszterhazy.framework.dao.repositories;

import hu.uni.eszterhazy.framework.dao.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
}
