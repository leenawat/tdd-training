package com.example.myapi.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("ดึงข้อมูลของด product id = 1 ได้")
    public void case01() {
        // Arrange
        Product newProduct = new Product();
        newProduct.setName("demo data");
        newProduct.setPrice(100);
        productRepository.save(newProduct);

        // Act
        Product product1 = productRepository.getById(1);

        // Assert
        assertEquals(1, product1.getId());
        assertEquals("demo data", product1.getName());
        assertEquals(100, product1.getPrice());
    }

    @Test
    @DisplayName("ดึงข้อมูลของด product id = 1 ไม่พบ")
    public void case02() {
        // Arrange

        // Act
        Product product = productRepository.getById(1);

        // Assert
        Exception exception = assertThrows(EntityNotFoundException.class,
                () -> product.getName());

        // assertEquals(1, product.getId());
        assertEquals("Unable to find com.example.myapi.product.Product with id 1", exception.getMessage());
    }
}
