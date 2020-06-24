package com.bikes.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 * very important to add Component scan so it can find the right classpath
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.bikes"})
public class BikesdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesdemoApplication.class, args);
	}

}
