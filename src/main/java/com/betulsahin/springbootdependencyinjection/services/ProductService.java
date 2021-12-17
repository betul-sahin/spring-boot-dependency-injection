package com.betulsahin.springbootdependencyinjection.services;

import com.betulsahin.springbootdependencyinjection.dto.ProductDto;
import com.betulsahin.springbootdependencyinjection.models.Product;
import com.betulsahin.springbootdependencyinjection.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    // @Autowired
    // private ProductRepository productRepository;

    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public Optional<Product> create(ProductDto request) {

        Product product = Product.builder()
                .category(request.getCategory())
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        Product savedProduct = productRepository.save(product);

        return Optional.of(savedProduct);
    }
}
