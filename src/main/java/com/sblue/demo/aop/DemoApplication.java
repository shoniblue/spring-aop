package com.sblue.demo.aop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sblue.demo.aop.functional.annotation.EnableSomething;
import com.sblue.demo.aop.functional.annotation.ExampleConfiguration;
import com.sblue.demo.aop.functional.web.FunctionalRestController;
import com.sblue.demo.aop.simple.annotation.PerformanceCheck;


@EnableSomething
@RestController
@SpringBootApplication(scanBasePackages= {"com.sblue.demo.aop.simple"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@GetMapping("/")
	@PerformanceCheck
	public String checkMyTime() {
		return "Hello.";
		
	}
	

	@Bean
	@ConditionalOnBean(ExampleConfiguration.class)
	public FunctionalRestController functionalRestController() {
		return new FunctionalRestController();
	}
	
}
