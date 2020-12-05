package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.repositories.CategoryRepository;
import hu.uni.eszterhazy.framework.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryDaoImpl implements CategoryDao {

    private final CategoryRepository categoryRepository;
    
    @Override
    public Collection<Category> readAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false).map((categoryEntity -> new Category(
                categoryEntity.getName()
        ))).collect(Collectors.toList());
    }
}
