package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.dao.CategoryDao;
import hu.uni.eszterhazy.framework.model.Category;
import hu.uni.eszterhazy.framework.model.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryDao dao;

    @Override
    public Collection<Category> listAll() {
        return dao.readAll();
    }

    @Override
    public String createCategory(Category category) {
        for (Category C : dao.readAll()) {
            if(C.getName().equals(category.getName())){
                return "Error : " + category + " Category already exists";
            }
        }
        dao.createCategory(category);
        return "Category : " + category + " Created";
    }

    @Override
    public String deleteCategory(String name) {
        for (Category C : dao.readAll()) {
            if(C.getName().equals(name)){
                dao.deleteCategory(name);
                return "Category "+ name +" was deleted";
            }
        }
        return "Category Does not exist ";
    }
}
