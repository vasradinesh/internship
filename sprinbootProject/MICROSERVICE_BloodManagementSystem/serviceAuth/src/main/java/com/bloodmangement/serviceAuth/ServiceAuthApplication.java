package com.bloodmangement.serviceAuth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition
public class ServiceAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAuthApplication.class, args);
	}

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8083");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("vasra dinesh");
        myContact.setEmail("dbvasra32@gmail.com");

        Info information = new Info()
                .title("Blood Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage auth.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }

}
