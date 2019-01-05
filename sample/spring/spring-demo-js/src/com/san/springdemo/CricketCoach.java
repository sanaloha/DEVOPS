package com.san.springdemo;

public class CricketCoach implements Coach {

	//define a private field for injection
	private FortuneService fortuneSerice;
	private String email;
	private String team;
	private String logo;
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		System.out.println("set logo " + logo);
		this.logo = logo;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("set team " + team);
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("set email " +email);
		this.email = email;
	}

	public FortuneService getFortuneSerice() {
		return fortuneSerice;
	}

	//inject dependency
	public void setFortuneSerice(FortuneService fortuneSerice) {
		System.out.println("injecting fortune via setter");
		this.fortuneSerice = fortuneSerice;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do batting practic for an hour";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneSerice.getFortune();
	}

}
