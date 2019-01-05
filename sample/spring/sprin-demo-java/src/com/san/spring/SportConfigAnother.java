package com.san.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfigAnother {
	
	//Define Bean for happyFortune Service
	@Bean
	FortuneService happyFortuneService(){
		
		return new HappyFortuneService();
	}
	//Define a bean for swimCoach and inject happy fortune service
	@Bean
	Coach swimCoach(){
		return new SwimCoach(happyFortuneService());
	}

}
