package com.example.myapi.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerSpringBootMockTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("ดึงข้อมูลของด product id = 1 ได้")
    public void case01() {
        // Arrange
        Product newProduct = new Product();
        newProduct.setId(1);
        newProduct.setName("demo data");
        newProduct.setPrice(100);
        when(productRepository.getById(1)).thenReturn(newProduct);

        // 2. call to /products/1
        ProductResponse productResponse = restTemplate.getForObject("/products/1", ProductResponse.class);

        // 3. Assert result with expected result
        assertEquals(newProduct.getId(), productResponse.getId());
        assertEquals(newProduct.getName(), productResponse.getProductName());
        assertEquals(newProduct.getPrice(), productResponse.getPrice());

    }
}
