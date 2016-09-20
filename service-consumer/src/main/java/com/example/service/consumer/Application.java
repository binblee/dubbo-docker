package com.example.service.consumer;

import com.example.service.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ImportResource({"classpath:services.xml"})
@RestController
public class Application {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @RequestMapping("/")
    public String greetings(){
        Greetings greetingService = (Greetings)context.getBean("greetingService");
        String result = greetingService.say("Dubbo Docker");
        return result;
    }
}
