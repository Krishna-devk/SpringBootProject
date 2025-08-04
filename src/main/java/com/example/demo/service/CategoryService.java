package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.exception.CategoryAlreadyExistException;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Optional<CategoryEntity> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistException("Category "+ categoryDTO.getName()+ " already Exist");
        }
        CategoryEntity categoryEntity = CategoryMapper.toCategory(categoryDTO);
        CategoryEntity save = categoryRepository.save(categoryEntity);
        return CategoryMapper.toCategoryDTO(save);
    }
    public List<CategoryDTO> getAllCategoryDTO(){
         return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    public CategoryDTO getCategoryDTOById(Long id){
        CategoryEntity byId = categoryRepository.findById(id)
                        .orElseThrow(()-> new CategoryNotFoundException("No Category with id: "+id+" exist "));
        return CategoryMapper.toCategoryDTO(byId);
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        // return "Deleted";
    }


}
