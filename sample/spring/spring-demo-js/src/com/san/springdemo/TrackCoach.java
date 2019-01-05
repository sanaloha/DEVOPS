package com.san.springdemo;

public class TrackCoach implements Coach {

	//define a private field for dependency
	FortuneService fortuneServie;
	
	//define a constructor for dependency injection
	TrackCoach(FortuneService fortuneServie){
	System.out.println("Inject Track fortune service dependecy via constructor");
		this.fortuneServie = fortuneServie;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Track spen time for 30 min running";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneServie.getFortune();
	}

}
