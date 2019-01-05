package com.san.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	//showForm Same mapping as hello controller
	@RequestMapping("/showForm")
	public String displayTheForm(){
		return "silly";
	}

}
