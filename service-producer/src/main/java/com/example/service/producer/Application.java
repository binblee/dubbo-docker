package com.example.service.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by libin on 9/19/16.
 */
@SpringBootApplication
@ImportResource({"classpath:services.xml"})
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
    }
}
