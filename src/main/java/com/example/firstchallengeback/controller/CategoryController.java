package com.example.firstchallengeback.controller;

import com.example.firstchallengeback.dto.CategoryDTO;
import com.example.firstchallengeback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo/category")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getAll")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("save")
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

}
