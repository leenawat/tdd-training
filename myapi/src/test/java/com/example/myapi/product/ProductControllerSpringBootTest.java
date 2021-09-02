package com.example.myapi.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

// 1. Start server
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerSpringBootTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void exampleTest() {
        // 2. call to /products/1
        ProductResponse productResponse = restTemplate.getForObject("/products/1", ProductResponse.class);

        // 3. Assert result with expected result
        assertEquals(1, productResponse.getId());
        assertEquals("พัดลม", productResponse.getProductName());
        assertEquals(1200.00, productResponse.getPrice());
    }

}
