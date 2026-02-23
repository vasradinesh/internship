package com.springboot.project14_derivedQueryMethod;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project14DerivedQueryMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project14DerivedQueryMethodApplication.class, args);
	}

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
