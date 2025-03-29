package com.tinnova.vehicles_rest_api.config.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Vehicles Rest API")
            .version("1.0.0")
            .description("API para gerenciamento de veículos")
            .contact(new Contact()
                .name("Thales Gomes Targino")
                .email("thalestargino@gmail.com")));
  }
}
