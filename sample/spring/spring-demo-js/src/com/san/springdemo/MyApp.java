package com.san.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * Inversion of control using xml configuration
 *Create application context  XML: Define beans
 * 		1 Define dependencies or helpers
 * 		2 Inject Dependencies using constructor
 * 		3 Inject Dependencies using setter
 * 		4 Inject Literals using setters
 * 		5 Inject Literals from property files
 * Load application context or spring container
 * Create objects form context
 * use the objects
 * close the context
 * 
 * **/
public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		//Coach theCoach = new BaseballCoach();
		//use the object
		//System.out.println(theCoach.getDailyWorkout());
		
		//create a spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from the container
		Coach theCoach = context.getBean("myCrickCoach",Coach.class);
		Coach theTrackCoach = context.getBean("myTrackCoach",Coach.class);
		//call method on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theTrackCoach.getDailyWorkout());
		//close the context
		context.close();
		
		

	}

}
