package com.mamdouh.aspects;

import java.util.Collection;

import org.apache.tomcat.util.buf.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.mamdouh.user.AppUser;

@Aspect
@Component
public class LoggingAspect {
	
	
	Logger log  = LoggerFactory.getLogger(LoggingAspect.class);
	

	
	
	@Around("execution(* com.mamdouh..*Service.*(..))")
	public void timeLogger(JoinPoint j) 
	{

		long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder("KPi");
		String args = j.getArgs().toString();
		
		sb.
		append("[")
		.append(j.getKind())
		.append("]\tfor: ")
		.append(j.getSignature())
		.append("\twithArgs: ")
		.append(args).append("]");
		
		log.info(sb.append(System.currentTimeMillis()-startTime).append("ms").toString());	
	}
	
	@After("execution(com.mamdouh.user.ApplicationUserService.signUpUser(.))")
	public void afterLogger() 
	{
		System.out.println("user created.");
		
	}

	

}
