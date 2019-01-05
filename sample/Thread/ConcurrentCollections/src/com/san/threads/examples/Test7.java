package com.san.threads.examples;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * 
 * Producer Consumer Solution
 * 
 * ****/

class Processor1{
	
	private List<Integer>  list = new ArrayList<>();
	private final int LIMIT = 5;
	private final int BOTTOM = 0;
	private final Object lock = new Object();
	private int value=0;
	
	
	
	public void produce() throws InterruptedException{
		
		synchronized (lock) {
			while(true){
				
				if(list.size() == LIMIT){
					System.out.println("waiting for removing items from the list");
					lock.wait();				
				}else{
					System.out.println("adding items: " + value);
					list.add(value);
					value++;
					lock.notify();
				}
				
			}
		}
		
		
	}
	
	public void consume() throws InterruptedException{
		synchronized (lock) {
			
				while(true){
				
				if(list.size() == BOTTOM){
					System.out.println("waiting for adding items to the list");
					lock.wait();
				}else{
					System.out.println("Removed items: " + list.remove(--value));
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}	
}

public class Test7 {
	
public static void main(String[] args) {
		
		Processor1  processor = new Processor1();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
	}

}
