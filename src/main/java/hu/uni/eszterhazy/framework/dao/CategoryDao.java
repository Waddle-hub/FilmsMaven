package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Category;

import java.util.Collection;

public interface CategoryDao {
    Collection<Category> readAll();
}
