package com.example.prolect09_oneToonebidirectional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Prolect09OneToonebidirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prolect09OneToonebidirectionalApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
