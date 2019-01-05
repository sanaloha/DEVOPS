package com.san.spring.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWorldInitializer  implements WebApplicationInitializer {
 
	
	public void onStartup(final ServletContext servletContext) throws ServletException {
		final AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.setServletContext(servletContext);
		root.scan("com.san.spring.configuration");
		root.refresh();

		final Dynamic servlet = servletContext.addServlet("spring", new DispatcherServlet(root));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");
	}
 
}