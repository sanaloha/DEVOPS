package com.san.threads.examples;


class Processor{
	
	public void produce() throws InterruptedException{
		//this is the lock of intrinsic class
		synchronized (this) {
			
			System.out.println("we are in the produce method");
			wait();
			System.out.println("Again in the produce method");
			
		}
		
	}
	
	public void consume() throws InterruptedException{
		
		Thread.sleep(1000);
			synchronized (this) {
				System.out.println("we are in the consumer method");
				notify();
				Thread.sleep(3000);
			}
	}
}

public class Test6Wait {
	
	
	public static void main(String[] args) {
		
		Processor  processor = new Processor();
		
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
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
