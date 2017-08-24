package com.sblue.demo.aop.functional.annotation;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example")
public class ExampleConfiguration {

	
	private String testValue = "default";
	public String getTestValue() {
		return testValue;
	}
	
	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}
}
