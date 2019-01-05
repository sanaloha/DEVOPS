package com.san.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
* Annotation minimizes the xml configuration
* Spring will scan your java classes for special annotations
* then it automatically register the beans in the spring container
*Steps:
*	1) Enable component scan in spring configuration file
*	2) add Component annotation to your java classes
*	3) Retrieve bean from spring controller
*Injection types
*	constructor injection
*	Setter injection
*	field injection
*
**/

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get the bean from spring container
		
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//call the dependent method
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
		
	}

}
