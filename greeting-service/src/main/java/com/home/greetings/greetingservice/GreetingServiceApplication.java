package com.home.greetings.greetingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class GreetingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

	@Bean
	Docket configureSwagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/base/*"))
				.apis(RequestHandlerSelectors.basePackage("com.home.greetings.greetingservice"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo(){
		return new ApiInfo("Greetings API",
				"Sample Greetings service",
				"1.0",
				"Terms - Free to use!!",
				new Contact
						("Aravind",
								"https://github.com/ariwind-home/greeting-service",
								"airwind85.dev@gmail.com"),
				"API License",
				"https://github.com/ariwind-home/greeting-service",
				Collections.emptyList());
	}


}
