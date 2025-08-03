package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;

public class ProductMapper {
    
    public static ProductDTO toProductDTO(ProductEntity product){
         return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory().getId()
         );

    }
    public static ProductEntity toProduct(ProductDTO productDTO,CategoryEntity category){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setCategory(category);
        return productEntity;
    }
   

    

}
