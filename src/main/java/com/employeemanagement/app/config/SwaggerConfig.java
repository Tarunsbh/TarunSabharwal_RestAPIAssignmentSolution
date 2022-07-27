package com.employeemanagement.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Employee Management System")
                                .description("REST API Employee Management System")
                                .version("v0.0.1")
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Employee Management System")
                                .url("Tarunsbh/Tarunsabharwal_RestAPIAssignmentSolution")
                );
    }
	
	public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api", HandlerTypePredicate.forAnnotation(RestController.class));
    }

}

