package hu.uni.eszterhazy.framework.dao.repositories;

import hu.uni.eszterhazy.framework.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
