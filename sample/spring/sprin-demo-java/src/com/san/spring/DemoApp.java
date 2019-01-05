package com.san.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {

	public static void main(String[] args) {
		//Read Spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from the spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//call the dependent method
		System.out.println(theCoach.getDailyFortune());
		
		//Read another config Designed to create bean using Bean annotation
		AnnotationConfigApplicationContext contextAnother = new AnnotationConfigApplicationContext(SportConfigAnother.class);
		
		//get the bean from the spring container
		SwimCoach theCoachAnother = contextAnother.getBean("swimCoach", SwimCoach.class);
		//call a method on the bean
		System.out.println(theCoachAnother.getDailyWorkOut());
		
		//call the dependent method
		System.out.println(theCoachAnother.getDailyFortune());
		
		//Display values referenced from property files
		System.out.println(theCoachAnother.getEmail());
		System.out.println(theCoachAnother.getTeam());
		//close the context
		context.close();
	
	}

}
