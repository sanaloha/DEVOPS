package com.san.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	//Create helper instance
	@Qualifier("happyFortuneService")
	@Autowired
	FortuneService fortuneService;
	

	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	//create setter for injection
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setter injection for fortune service");
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "do batting practice for an hour";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
