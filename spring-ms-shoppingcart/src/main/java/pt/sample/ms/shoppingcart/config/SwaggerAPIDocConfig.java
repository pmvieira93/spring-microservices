package pt.sample.ms.shoppingcart.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author pedro.vieira
 * Following: {https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-swagger/}
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerAPIDocConfig {
	
	/*
	 * Swagger UI: http://localhost:8080/swagger-ui.html
	 * Swagger Data: http://localhost:8080/v2/api-docs
	 */

	/**
	 * Enable Swagger API Documentation
	 * 
	 * @return
	 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(getApiInfo());
    }
	
	/**
	 * Customization of Swagger API UI Information
	 * 
	 * @return	Api Information
	 */
	private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Contact Application API",
                "This is a sample Spring Boot RESTful service using SpringFox + Swagger 2",
                "V1",
                "urn:tos",
                new Contact("Dariawan", "https://www.dariawan.com", "hello@dariawan.com"),
                "CC BY-SA 3.0",
                "https://creativecommons.org/licenses/by-sa/3.0/",
                Collections.emptyList()
        );
    }
	
}
