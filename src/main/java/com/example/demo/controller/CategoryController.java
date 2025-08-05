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
import com.example.demo.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@Tag(
    name="Category Rest Api Controllers",
    description="CRUD operations for the category REST API"
)

@RequestMapping("/api/categories")
@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    @Operation(
        summary = "Fetch All Categories",
        description = "REST API to fetch all categories"
    )
    @GetMapping
    public List<CategoryDTO> getAllCategoryDTO(){
        return categoryService.getAllCategoryDTO();

    }
    @Operation(
        summary = "Create a Category",
        description = "REST API to create a category"
    )
    
    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody CategoryDTO categoryDTO){
            CategoryDTO category = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);        
    }

    @Operation(
        summary = "Fetch Category by Id",
        description = "REST API to fetch category by id"
    )

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryDTOById(id),
        HttpStatus.FOUND);
    }
    @Operation(
        summary = "Delete category by id",
        description = "REST API to delete category by id"
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    

}
