package com.example.demo.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
    name = "Category",
    description = "It holds the Category info along with the Products belonging to that category"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String name;
    private Long id;
    private List<ProductDTO> productDTO;
}
