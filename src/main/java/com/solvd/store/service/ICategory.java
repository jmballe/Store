package com.solvd.store.service;

import com.solvd.store.models.Category;

public interface ICategory {
    Category getCategoryById(int id);
    void update(Category entity);
    void create(Category entity);
    void delete(Category entity);
}
