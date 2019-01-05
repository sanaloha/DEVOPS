package com.san.basic.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 
 * Rentrant locks
 * 	-It has the same behavior as "synchronized approach"
 * 	-of course it has additional features
 * 	new ReentrantLock(boolean fairnessParameter)
 * 	-fairness parameter: if it is set to true---> the longest-waiting thread 
 * 	will get the lock
 * 	fairness == false ---> There is no access order.
 * 	Important: We have to use try-catch block when doing critical section
 * 	that may throws exceptions
 * 	~ we call unlock in the finally block !!!
 * 	
 * 
 * 
 * ***/

public class App {

	
	private static int counter =0;
	private static Lock lock = new ReentrantLock();

	/*
	 * mehtod without lock produce inconsistent behavior
	 * public static void increment(){
		for(int i =0; i < 10000;i++){
			counter++;
		}
	}*/
	
	
	public static void increment(){
		lock.lock();
		
		try{
			for(int i =0; i < 10000;i++)
				counter++;
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
			
				increment();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
			
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Counter " + counter);
	}

}
