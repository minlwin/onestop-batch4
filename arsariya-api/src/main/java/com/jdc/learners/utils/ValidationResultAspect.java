package com.jdc.learners.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Aspect
@Configuration
public class ValidationResultAspect {

	@Pointcut("within(com.jdc.learners.api.*.*) and @within(org.springframework.web.bind.annotation.RestController)")
	public void apiClasses() {}
	
	@Before(value = "apiClasses() and args(.., result)", argNames = "result")
	public void checkResult(BindingResult result) {
		if(result.hasErrors()) {
			throw new ValidationResultException(result);
		}
	}
}
