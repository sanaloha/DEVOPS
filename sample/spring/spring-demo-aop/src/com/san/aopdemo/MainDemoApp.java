package com.san.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.san.aopdemo.dao.AccountDAO;
import com.san.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO theAccountDAO =  context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method 
		theAccountDAO.addAccount();
		
		//call the membership bean
		MembershipDAO theMembershipDAO =  context.getBean("membershipDAO", MembershipDAO.class);
		theMembershipDAO.addAccount();
		//close the context
		context.close();

	}

}
