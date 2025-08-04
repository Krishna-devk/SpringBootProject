package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
    name="Product Rest Api Controllers",
    description="CRUD operations for the product REST API"
)

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProductDTO(productDTO),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllProductDTO(){

        return new ResponseEntity<>(productService.getAllProductDTO(),HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDTOById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductDTOById(id),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        ProductDTO updateProductDTO = productService.updateProductDTO(id, productDTO);
        return new ResponseEntity<>(updateProductDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
