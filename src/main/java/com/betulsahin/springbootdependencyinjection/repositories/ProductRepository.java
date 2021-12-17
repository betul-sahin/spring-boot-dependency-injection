package com.betulsahin.springbootdependencyinjection.repositories;

import com.betulsahin.springbootdependencyinjection.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByTitle(String title);
}
