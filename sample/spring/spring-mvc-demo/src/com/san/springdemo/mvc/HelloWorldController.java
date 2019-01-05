package com.san.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	
	//controller method to show the initial html form
	//controller method to process the html form
	
	//Method to show initial html form
	@RequestMapping("/showForm")
	public String showForm(){
		
		return "helloworld-form";
	}
	//controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	//Use of models
	@RequestMapping("/processFormVersionTwo")
	public String useModel(HttpServletRequest request, Model model){
		
		//read the request parameter from html form 
		String theName = request.getParameter("studentName");
		//convert to upper case
		theName = theName.toUpperCase();
		//create the message
		String result = "Hi " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	//Use of RequestParam annotation
	@RequestMapping("/processFormVersionThree")
	public String useRequestParam(@RequestParam("studentName") String theName,
			Model model){
		
		//Behind the scene spring will read param from request: studentName and 
		//bind it to variable name theName
		theName = theName.toUpperCase();
		//create the message
		String result = "Hi Hello " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	

}
