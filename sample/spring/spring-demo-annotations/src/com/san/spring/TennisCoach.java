package com.san.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * if name of bean is not given then it would take a default bean id 
 * from class name as tennisCoach
 * **/
@Component("thatSillyCoach") 
public class TennisCoach implements Coach {

	

	//Create dependency or helper property, field level injection
	//it will set the fortune service with the qualifier object
	@Qualifier("happyFortuneService")
	@Autowired
	FortuneService fortuneServie;
	
	//inject  helper object using constructor
	/*@Autowired
	public TennisCoach(FortuneService fortuneServie) {
		System.out.println("initialize fortune using constructor");
		
		this.fortuneServie = fortuneServie;
	}	*/
	
	@Override
	public String getDailyWorkOut() {
		
		return "Practice your service";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneServie.getFortune();
	}

}
