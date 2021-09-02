package com.example.myapi.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    void getProductDetail() throws Exception {

        // Arrange
        ProductResponse expected = new ProductResponse();
        expected.setId(1);
        expected.setProductName("พัดลม");
        expected.setPrice(1200);

        given(this.productService.getProductDetail(1))
                .willReturn(expected);

        // Act
        MvcResult mvcResult = this.mvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andReturn();

        byte[] resultJson = mvcResult.getResponse().getContentAsByteArray();
        ObjectMapper objectMapper = new ObjectMapper();
        ProductResponse actualResponse = objectMapper.readValue(resultJson, ProductResponse.class);

        // Assert
        // 3. Assert result with expected result
        assertEquals(expected.getId(), actualResponse.getId());
        assertEquals(expected.getProductName(), actualResponse.getProductName());
        assertEquals(expected.getPrice(), actualResponse.getPrice());

        assertEquals(expected, actualResponse);
    }
}
