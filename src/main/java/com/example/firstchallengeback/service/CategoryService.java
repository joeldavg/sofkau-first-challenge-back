package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    CategoryDTO findById(Long id);

}
