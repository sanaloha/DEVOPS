package com.san.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction  extends RecursiveAction{
	
	private int simulatedWork;
	
	public SimpleRecursiveAction(int simulatedWork){
		this.simulatedWork = simulatedWork;
	}
	
	@Override
	public void compute(){
		
		if(simulatedWork >100){
			//Create two subtask
			System.out.println("Parallel execution and split task " + simulatedWork);
			
			SimpleRecursiveAction simpleRecAction1 = new  SimpleRecursiveAction(simulatedWork/2);
			SimpleRecursiveAction simpleRecAction2 = new  SimpleRecursiveAction(simulatedWork/2);
			
			//when we call this fork then these are recursive actions so the recursive action of one 
			//recursive action too is going to be inserted into that given pool.So basically the threads 
			//in that given pool are able to execute these tasks and basically that so we
			simpleRecAction1.fork();
			simpleRecAction2.fork();
			
		}else{
			System.out.println("No parallel processing required, sequential algorithm " + simulatedWork);
		}
		
		
	}

}
