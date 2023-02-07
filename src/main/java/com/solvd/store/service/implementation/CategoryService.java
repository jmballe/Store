package com.solvd.store.service.implementation;

import com.solvd.store.dao.ICategoryDAO;
import com.solvd.store.dao.mySQL.CategoryDAO;
import com.solvd.store.models.Category;
import com.solvd.store.service.ICategory;

import java.io.IOException;

public class CategoryService implements ICategory {
    private final ICategoryDAO categoryDAO;

    public CategoryService() throws IOException {
        this.categoryDAO = new CategoryDAO();
    }

    @Override
    public void create(Category category) {
        category.setCategory_id(null);
        categoryDAO.create(category);
    }

    @Override
    public void delete(Category entity) {
        categoryDAO.delete(entity);
    }

    @Override
    public Category getEntityById(int id) {
        return categoryDAO.getEntityById(id);
    }

    @Override
    public void update(Category entity) {
        categoryDAO.update(entity);
    }

}
