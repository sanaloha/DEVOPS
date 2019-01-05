package com.san.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAppSetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//read spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get the bean from spring container
				
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		//call the dependent method
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();

	}

}
