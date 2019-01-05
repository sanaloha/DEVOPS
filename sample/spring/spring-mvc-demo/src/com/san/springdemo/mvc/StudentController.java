package com.san.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//Take it from properties
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model){
		//create student object
		
		Student theStudent = new Student();
		//add student to the model
		model.addAttribute("student", theStudent);
		
		//(take from properties)add the country options to the model 
	    model.addAttribute("theCountryOptions", countryOptions); 
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent){
		
		//log the input data
		System.out.println("theStudent " + theStudent.getFirstName());
		return "student-confirmation";
		
	}

}
