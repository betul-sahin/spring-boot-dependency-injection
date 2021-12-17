package com.betulsahin.springbootdependencyinjection.controllers;

import com.betulsahin.springbootdependencyinjection.dto.ProductDto;
import com.betulsahin.springbootdependencyinjection.models.Product;
import com.betulsahin.springbootdependencyinjection.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDto request){

        Optional<Product> productOptional = productService.create(request);
        if(!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productOptional.get(), HttpStatus.CREATED);
    }

}
