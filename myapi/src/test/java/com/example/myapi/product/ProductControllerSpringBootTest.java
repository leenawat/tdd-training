package com.example.myapi.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;

// 1. Start server
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerSpringBootTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getProductById() {
        ProductResponse expected = new ProductResponse();
        expected.setId(1);
        expected.setProductName("พัดลม");
        expected.setPrice(1200);
        productRepository.save(Product
                .builder()
                .id(1)
                .name("พัดลม")
                .price(1200)
                .build());

        // 2. call to /products/1
        ProductResponse productResponse = restTemplate.getForObject("/products/1", ProductResponse.class);

        // 3. Assert result with expected result
        assertEquals(expected.getId(), productResponse.getId());
        assertEquals(expected.getProductName(), productResponse.getProductName());
        assertEquals(expected.getPrice(), productResponse.getPrice());

        assertEquals(expected, productResponse);

    }

    @Test
    @Sql(scripts = "classpath:data_init.sql")
    void getProductById_PrepareWithSQL() {
        ProductResponse expected = new ProductResponse();
        expected.setId(2);
        expected.setProductName("พัดลม");
        expected.setPrice(1200);

        // 2. call to /products/1
        ProductResponse productResponse = restTemplate.getForObject("/products/2", ProductResponse.class);

        // 3. Assert result with expected result
        assertEquals(expected.getId(), productResponse.getId());
        assertEquals(expected.getProductName(), productResponse.getProductName());
        assertEquals(expected.getPrice(), productResponse.getPrice());

        assertEquals(expected, productResponse);

    }
}
