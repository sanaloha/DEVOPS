package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Below annotation says spring that this is the class need to boot
 * 
 * **/
@SpringBootApplication  //tells the Spring this is the starting point of the application
public class CourseApiApp {

	/**
	 * Below main method creates Servlet container, starts it and host your
	 * application into that Servlet Container
	 * **/
	public static void main(String[] args) {
		
		/** below static run method Starts servlet container and host the application
		 * 
		 *  **/
		SpringApplication.run(CourseApiApp.class, args);
		
		/**
		 * 1.Sets up default configuration
		 * 2.Starts Spring application context, It is the container for all your code
		 * 3.performs class path scan
		 * 4.starts tomcat server
		 * 
		 * **/

	}

}
