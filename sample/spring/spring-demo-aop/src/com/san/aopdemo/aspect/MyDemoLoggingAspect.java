package com.san.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//Create Pointcut
	@Pointcut("execution(public void addAccount())")
	private void forDaoPackage(){}
	
	//add advice for logging
	
	//before advice
	
	//@Before("execution(public void addAccount())")
	@Before("forDaoPackage()")
	public void beforeAddAccount(){
		System.out.println("Beofore logging advice");
	}

}
