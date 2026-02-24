package com.springboot.project17_fileHandling;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project17FileHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project17FileHandlingApplication.class, args);
	}

    @Bean
    public Faker faker(){
        return new Faker();
    }

}
