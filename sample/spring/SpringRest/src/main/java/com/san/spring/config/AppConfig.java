package com.san.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.san.spring")
public class AppConfig {
	
	public AppConfig(){
	
		System.out.println("Inside App Config==================");
	}
	
	

}
