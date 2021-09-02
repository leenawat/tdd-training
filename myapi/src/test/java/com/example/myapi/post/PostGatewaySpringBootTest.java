package com.example.myapi.post;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostGatewaySpringBootTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    public void getPostById() {
        // Act
        Optional<PostResponse> result = postGateway.getPostById(1);

        // Assert
        assertTrue(result.isPresent());

    }
}
