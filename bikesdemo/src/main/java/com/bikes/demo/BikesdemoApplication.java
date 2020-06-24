package com.bikes.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/***
 * very important to add Component scan so it can find the right classpath
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.bikes"})
@EntityScan("com.bikes.models")
@EnableJpaRepositories("com.bikes.repositories")
public class BikesdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesdemoApplication.class, args);
	}

}
