package com.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@PropertySource("classpath:/application.properties")
public class ServiceImplementation implements com.aop.Service{
	
	@Value("${email}")
	private String email;
    
    @Override
	public String getEmail() {
    	System.out.println(email);
		return email;
		
	}
}
