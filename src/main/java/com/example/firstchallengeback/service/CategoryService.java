package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dao.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category saveCategory(Category category);

    void deleteCategory(Long id);

}
