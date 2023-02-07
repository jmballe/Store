package com.solvd;

import com.solvd.store.models.Category;
import com.solvd.store.service.implementation.CategoryService;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        CategoryService catService = new CategoryService();

        Category bagsCat = new Category("Bags","All king of bags.");

        catService.create(bagsCat);

        Category cat = catService.getCategoryById(bagsCat.getCategory_id());

        catService.delete(bagsCat);

        System.out.println(cat.getCategory_id() + " | " + cat.getName());

    }
}