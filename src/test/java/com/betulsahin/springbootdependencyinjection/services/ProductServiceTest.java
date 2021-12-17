package com.betulsahin.springbootdependencyinjection.services;

import com.betulsahin.springbootdependencyinjection.dto.ProductDto;
import com.betulsahin.springbootdependencyinjection.models.Product;
import com.betulsahin.springbootdependencyinjection.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    /*

    TALIMATLAR
    - Bu testi calistirip hata alin.
    - Ardindan ProductService'e gidip ilgili düzenlemeyi yapin. Ve buradaki setup() metodunda ilgili duzenlemeyi yapin.
    - Testi tekrar calistirip yesil oldugunu gorun.

    Keep coding :)

     */
    ProductRepository mockProductRepository;

    ProductService underTest;

    @BeforeEach
    void setup(){
        mockProductRepository = mock(ProductRepository.class);
        underTest = new ProductService();
    }

    @Test
    void create_shouldRegisterNewProduct(){
        // given
        Product expected = new Product();
        expected.setTitle("Laptop");

        ProductDto request = new ProductDto();
        request.setTitle("Laptop");

        when(mockProductRepository.save(any()))
                .thenReturn(expected);

        // when
        Optional<Product> actual = underTest.create(request);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual.get()),
                () -> assertEquals(expected.getTitle(), actual.get().getTitle())
        );
    }
}