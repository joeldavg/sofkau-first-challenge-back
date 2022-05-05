package com.example.firstchallengeback.controller;

import com.example.firstchallengeback.dao.entity.Category;
import com.example.firstchallengeback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getAll")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

}
