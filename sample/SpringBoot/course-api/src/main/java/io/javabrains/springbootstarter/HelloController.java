package io.javabrains.springbootstarter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	//Below is the rest end point exposed
	
	@RequestMapping("/hello")
	public String sayHi(){
		
		return "Hi";
	}

}
