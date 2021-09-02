package com.example.myapi.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class PostGateway {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${post_url}")
    private String postUrl;

    // https://jsonplaceholder.typicode.com/posts/1
    public Optional<PostResponse> getPostById(int id) {
        String url = postUrl + "/posts/" + id;
        try {
            PostResponse response = restTemplate.getForObject(url, PostResponse.class);
            return Optional.ofNullable(response);
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
