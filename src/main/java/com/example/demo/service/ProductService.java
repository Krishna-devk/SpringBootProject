package com.example.demo.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //create a new product
    public ProductDTO createProductDTO(ProductDTO productDTO){
        CategoryEntity byId = categoryRepository.findById(productDTO.getCategoryId())
                                            .orElseThrow(()-> new CategoryNotFoundException("Category not found"));
        ProductEntity product = ProductMapper.toProduct(productDTO,byId);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
    //get list of all the products
    public List<ProductDTO> getAllProductDTO(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }
    //delete product by id
    public void deleteProductById(Long id){
        productRepository.deleteById(id);

    }

    // get product by id
    public ProductDTO getProductDTOById(Long id){
        ProductEntity byId = productRepository.findById(id)
        .orElseThrow(()->new ProductNotFoundException("No Product having id: "+id+" exist"));
        return ProductMapper.toProductDTO(byId);
    }

    //update product
    public ProductDTO updateProductDTO(Long id,ProductDTO productDTO){
        ProductEntity productEntity = productRepository.findById(id)
        .orElseThrow(()-> new ProductNotFoundException("No Product Corresponding to this id"));
        CategoryEntity categoryEntity = categoryRepository.findById(productDTO.getCategoryId())
        .orElseThrow(()-> new CategoryNotFoundException("No Category Corresponding to this id"));

        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setCategory(categoryEntity);
        productRepository.save(productEntity);
        return ProductMapper.toProductDTO(productEntity);
    }




}
