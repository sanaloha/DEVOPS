
package com.san.springdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseballCoach implements Coach{
	
	//define a private field for dependency
	FortuneService fortuneService;
	
	
	@Override
	public String getDailyWorkout(){
		
		return "spend 30 minute for batting";
	}
	
	//define a constructor for the dependency injection
	
	BaseballCoach(FortuneService fortuneService){
		System.out.println("Inject Dependency");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
}