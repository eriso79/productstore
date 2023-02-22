package com.deverything.candidate.app.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication(scanBasePackages = "com.deverything.candidate")
@EnableJpaRepositories(basePackages = "com.deverything.candidate") 
@EntityScan("com.deverything.candidate")  

@EnableSwagger2
public class AppInitialization {
	
	public static void main(String[] args) {
		SpringApplication.run(AppInitialization.class, args);
	}

}


