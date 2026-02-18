package com.springboot.project11_manyToMany;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project11ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project11ManyToManyApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
