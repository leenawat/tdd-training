package com.example.myapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyapiApplication {

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
