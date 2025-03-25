package com.techcombank.vn.mr_engine.infrastructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {
    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("JWT Authorization")
                .in(SecurityScheme.In.HEADER)
                .description("Enter your token in the format **Bearer {token}**");

        return new OpenAPI()
                .info(new Info()
                        .title("Audience Store API")
                        .version("1.0")
                        .description("API documentation for Audience Store API"))
                .addSecurityItem(new SecurityRequirement().addList("JWT Authorization"))
                .components(new io.swagger.v3.oas.models.Components().addSecuritySchemes("JWT Authorization", securityScheme));
    }
}
