package com.example.firstchallengeback.dto.mapper;

import com.example.firstchallengeback.dao.entity.Category;
import com.example.firstchallengeback.dto.CategoryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class})
public interface CategoryMapper {

    CategoryDTO toCategoryDTO(Category category);

    List<CategoryDTO> toCategoriesDTO(List<Category> categories);

    @InheritInverseConfiguration
    Category toCategory(CategoryDTO categoryDTO);

    List<Category> toCategories(List<CategoryDTO> categoriesDTOs);

}
