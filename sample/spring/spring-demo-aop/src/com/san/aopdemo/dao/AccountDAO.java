package com.san.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount(){
		System.out.println(getClass() + "Doing DB work Add Account");
	}

}
