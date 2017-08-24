package com.sblue.demo.aop.functional.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sblue.demo.aop.functional.annotation.ExampleConfiguration;

@ConditionalOnBean(ExampleConfiguration.class)
@RestController
public class FunctionalRestController {
	@Autowired
	public ExampleConfiguration config;


	@GetMapping("/enabled")
	public String isEnabled() {
		return config.getTestValue();
	}
	
	
}
