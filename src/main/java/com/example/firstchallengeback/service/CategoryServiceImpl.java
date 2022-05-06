package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dao.entity.Category;
import com.example.firstchallengeback.dao.repository.CategoryRepository;
import com.example.firstchallengeback.dto.CategoryDTO;
import com.example.firstchallengeback.dto.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = mapper.toCategoriesDTO(categories);
        return categoriesDTO;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = mapper.toCategory(categoryDTO);
        Category saveCategory = categoryRepository.save(category);
        CategoryDTO saveCategoryDTO = mapper.toCategoryDTO(saveCategory);
        return saveCategoryDTO;
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryDTO categoryDTO = findById(id);
        if (!categoryDTO.getTasks().isEmpty()) {
            categoryDTO.getTasks()
                    .forEach(task -> taskService.deleteTask(task.getId()));
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        CategoryDTO categoryDTO = mapper.toCategoryDTO(category);
        return categoryDTO;
    }

}
