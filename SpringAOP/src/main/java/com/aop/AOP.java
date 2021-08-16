package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
@PropertySource("classpath:properties.yml")
public class AOP {

	@Before("execution(public String getService())")
	public void beforeAdviced() {
		System.out.println("Before getService() Advice executed");

	}

	@After("execution(public String getService())")
	public void afterAdviced() {
		System.out.println("After getService() Advice executed");

	}

	@Value("${emails}")
	private String emails;

	@Value("${email}")
	private String email;

	@Around("execution(public String getEmail())")
	public Object aroundAdvice() {

		setEmail(emails);
		System.out.println(email);

		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
