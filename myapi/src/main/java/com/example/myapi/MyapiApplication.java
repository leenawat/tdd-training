package com.example.myapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyapiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyapiApplication.class, args);
        int count = context.getBeanDefinitionCount();
        System.out.println("All beans = " + count);

        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);

        }
    }

}
