package com.betulsahin.springbootdependencyinjection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    @NotEmpty
    @Size(max=50, message = "Product name cannot be greater than 50 characters")
    private String title;

    @NotEmpty
    @Size(max=500, message = "Product description cannot be greater than 500 characters")
    private String description;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double price;

    @NotEmpty
    @Size(max=50, message = "Category name cannot be greater than 50 characters")
    private String category;
}
