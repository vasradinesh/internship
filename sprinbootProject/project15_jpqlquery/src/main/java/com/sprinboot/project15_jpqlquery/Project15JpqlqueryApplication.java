package com.sprinboot.project15_jpqlquery;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project15JpqlqueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project15JpqlqueryApplication.class, args);
	}

    @Bean
    public Faker faker(){
        return new Faker();
    }

}
