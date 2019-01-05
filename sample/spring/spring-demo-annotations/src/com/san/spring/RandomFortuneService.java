package com.san.spring;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String [] data = {"Happy fortune","good fortune","very good fortune"};
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Random Fortune";
	}

}
