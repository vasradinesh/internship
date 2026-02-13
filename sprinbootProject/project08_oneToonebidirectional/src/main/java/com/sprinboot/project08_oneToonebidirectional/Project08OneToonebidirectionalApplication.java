package com.sprinboot.project08_oneToonebidirectional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project08OneToonebidirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project08OneToonebidirectionalApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
