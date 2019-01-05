package com.san.spring.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Inside Servlet Mapping==================");
		return new String[] { "/" };
	}

}
