package com.fernandocanabarro.cardboard_dio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(
                new Info()
                    .title("Cardboard API")
                    .version("FernandoCanabarroAhnert")
                    .description("Este é um projeto baseado no desafio da DIO de Board de Tarefas. Ao invés de utilizar o JDBC com interação via terminal, utilizei o Spring Boot com MySQL e Docker, e fiz documentação via OpenAPI/Swagger.")
            )
            .externalDocs(
                new ExternalDocumentation()
                    .description("Link do GitHub do Projeto")
                    .url("https://github.com/FernandoCanabarroAhnert/cardboard-dio")
            );
    }

}
