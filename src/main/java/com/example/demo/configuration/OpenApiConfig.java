package com.example.demo.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server codespacesServer = new Server()
            .url("https://crispy-system-q7x56j54r57q3pw4-8080.app.github.dev")
            .description("GitHub Codespaces URL");

        return new OpenAPI()
            .info(new Info().title("My API").version("1.0"))
            .servers(List.of(codespacesServer));
    }
}
