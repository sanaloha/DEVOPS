package com.san.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	/**Define a controller method
	 * Define request mapping
	 * return a view
	 * @return
	 */
	@RequestMapping("/")
	public String showPage(){
		
		return "main-menu";
	}
	

}
