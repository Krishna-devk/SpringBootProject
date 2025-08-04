package com.example.demo.mapper;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;

public class CategoryMapper {

     public static CategoryEntity toCategory(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity();
        
        categoryEntity.setName(categoryDTO.getName());
        
        return categoryEntity;
    }

    public static CategoryDTO toCategoryDTO(CategoryEntity categoryEntity){
        if(categoryEntity == null) return null;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setProductDTO(categoryEntity.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }

    
}
