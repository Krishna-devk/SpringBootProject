package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = CategoryMapper.toCategory(categoryDTO);
        CategoryEntity save = categoryRepository.save(categoryEntity);
        return CategoryMapper.tCategoryDTO(save);
    }


}
