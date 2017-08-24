package com.sblue.demo.aop.simple.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

	@Pointcut("@annotation(com.sblue.demo.aop.simple.annotation.PerformanceCheck)")
	public void performanceCheck() {}
	
	
	@Around("performanceCheck()")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();

		Object proceed = pjp.proceed();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println(pjp.getSignature() + "-- Time to execute: " + time);
		return proceed;
	}
	
}
