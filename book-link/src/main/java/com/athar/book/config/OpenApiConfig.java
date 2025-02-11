package com.athar.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Athar",
                        email = "ath.pnh@gmail.com",
                        url = "https://some-url.com"
                ),
                description = "OpenApi documentation for Spring security",
                title = "OpenApi specification - Athar",
                version = "3.0",
                license = @License(
                        name = "license name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Term of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8088/api/v1"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://some-url.com"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "BearerAuth"
                )

        }
)
@SecurityScheme(
        name = "BearerAuth",
        description = "JWT Authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

//    @Bean  // This is the crucial part that was missing
//    public OpenAPI customOpenAPI() {
//
//        return new OpenAPI()
//                .info(new io.swagger.v3.oas.models.info.Info() // Use the fully qualified name or an alias
//                        .title("Your API Title")
//                        .version("1.0")
//                        .description("Your API Description")
//                        .contact(new io.swagger.v3.oas.models.info.Contact() // Use the aliased Contact class
//                                .name("Athar")
//                                .email("ath.pnh@gmail.com")
//                                .url("https://some-url.com"))
//                        .license(new io.swagger.v3.oas.models.info.License() // Use the aliased License class
//                                .name("license name")
//                                .url("https://some-url.com"))
//                        .termsOfService("Term of service"))
//                .servers(List.of(
//                        new io.swagger.v3.oas.models.servers.Server().url("http://localhost:8088/api/v1").description("Local ENV"), // Use the aliased Server class
//                        new io.swagger.v3.oas.models.servers.Server().url("https://some-url.com").description("PROD ENV")  // Use the aliased Server class
//                ));
//    }
}