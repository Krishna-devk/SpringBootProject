package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;

import lombok.AllArgsConstructor;

@RequestMapping("/api/categories")
@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    
    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO),HttpStatus.ACCEPTED);
    }

    

}
