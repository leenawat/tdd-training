package com.example.myapi.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("success case")
    public void getById() {
        // Arrange
        ProductService productService = new ProductService(productRepository);
        Product product = Product.builder()
                .id(1)
                .name("Test with mockito")
                .build();
        when(productRepository.getById(1)).thenReturn(product);

        // Act
        ProductResponse result = productService.getProductDetail(1);

        // Assert
        assertEquals(product.getId(), result.getId());
        assertEquals(product.getName(), result.getProductName());
    }
}
