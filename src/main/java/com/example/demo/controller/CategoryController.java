package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.exception.CategoryAlreadyExistException;
import com.example.demo.service.CategoryService;

import lombok.AllArgsConstructor;

@RequestMapping("/api/categories")
@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategoryDTO(){
        return categoryService.getAllCategoryDTO();

    }
    
    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody CategoryDTO categoryDTO){
            CategoryDTO category = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryDTOById(id),
        HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    

}
