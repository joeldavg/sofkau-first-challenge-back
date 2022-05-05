package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dao.entity.Category;
import com.example.firstchallengeback.dao.entity.Task;
import com.example.firstchallengeback.dao.repository.CategoryRepository;
import com.example.firstchallengeback.dto.CategoryDTO;
import com.example.firstchallengeback.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> categoriesDTO = toCategoriesDTO(categories);

        return categoriesDTO;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {

        Category category = toCategory(categoryDTO);
        Category saveCategory = categoryRepository.save(category);
        CategoryDTO saveCategoryDTO = toCategoryDTO(saveCategory);

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
        CategoryDTO categoryDTO = toCategoryDTO(category);
        return categoryDTO;
    }

    private CategoryDTO toCategoryDTO(Category saveCategory) {
        CategoryDTO saveCategoryDTO = new CategoryDTO();
        saveCategoryDTO.setId(saveCategory.getId());
        saveCategoryDTO.setTitle(saveCategory.getTitle());
        List<Task> tasks = saveCategory.getTasks();
        if (!tasks.isEmpty()) {
            List<TaskDTO> taskDTOS = tasks.stream()
                    .map(task -> toTaskDTO(task)).collect(Collectors.toList());
            saveCategoryDTO.setTasks(taskDTOS);
        }
        return saveCategoryDTO;
    }

    private List<CategoryDTO> toCategoriesDTO(List<Category> categories) {
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        categoriesDTO = categories.stream()
                .map(category -> toCategoryDTO(category)).collect(Collectors.toList());
        return categoriesDTO;
    }

    private Category toCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setTitle(categoryDTO.getTitle());
        return category;
    }

    private TaskDTO toTaskDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setMessage(task.getMessage());
        taskDTO.setDone(task.getDone());
        taskDTO.setCategoryId(task.getCategoryId());
        return taskDTO;
    }


}
