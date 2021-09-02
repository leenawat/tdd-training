package com.example.myapi;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.myapi.product.Product;
import com.example.myapi.product.ProductRepository;

@SpringBootApplication
public class MyapiApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void initialData() {
        productRepository.save(Product
                .builder()
                .name("fan")
                .price(888)
                .build());
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyapiApplication.class, args);

        // String[] names = context.getBeanDefinitionNames();
        // Option 1
        // for (String name : names) {
        // System.out.println(name);
        // }
        // Option 3
        // Arrays.stream(names).forEach(System.out::println);

        // Option 3
        // Arrays.stream(names).forEach((name) -> System.out.println(name));

        int count = context.getBeanDefinitionCount();
        System.out.println("All beans = " + count);
    }

}
