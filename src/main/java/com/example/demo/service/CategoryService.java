package com.example.demo.service;
import java.util.List;
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
    public List<CategoryDTO> getAllCategoryDTO(){
         return categoryRepository.findAll().stream().map(CategoryMapper::tCategoryDTO).toList();
    }
    public CategoryDTO getCategoryDTOById(Long id){
        CategoryEntity byId = categoryRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("No Category Corresponding to the given id"));
        return CategoryMapper.tCategoryDTO(byId);
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        // return "Deleted";
    }


}
