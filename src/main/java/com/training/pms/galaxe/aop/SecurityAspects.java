package com.training.pms.galaxe.aop;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspects {
	@Before(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void logIn() {
		System.out.println("logIn method called :"+new Date()+ " By Aspects");
	}

	@After(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void logOut() {
		System.out.println("###log out method called :"+new Date()+ " By Aspects");
	}
}
