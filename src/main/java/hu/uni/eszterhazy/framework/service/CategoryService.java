package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Category;
import hu.uni.eszterhazy.framework.model.Language;

import java.util.Collection;

public interface CategoryService {
    Collection<Category> listAll();
    String createCategory(Category category);
    String deleteCategory(String name);
}
