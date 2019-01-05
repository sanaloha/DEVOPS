package com.san.threads.examples;


class RunnerTh3 extends Thread{
	
	public void startrunning(){
		
		for(int i=0;i<10;i++){
			System.out.println("runner 3 " + i);
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	@Override
	public void run() {
		this.startrunning();
	}
	
}

class RunnerTh4 extends Thread{
	public void startrunning(){
		
		for(int i=0;i<10;i++){
			System.out.println("runner 4 " + i);
			try {
				
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Override
	public void run() {
		this.startrunning();
	}
	
}

public class Test2 {


public static void main(String[] args) {
	
	RunnerTh3 th1 = new RunnerTh3();
	RunnerTh4 th2 = new RunnerTh4();
	
	th1.start();
	th2.start();
	//watch out for below, it executed before other threads as it is run by the application thread
	//
	System.out.println("Finish the code");
	//To avoid this we can use joins
	// This feature may prove to be very very important. Let's suppose the fact 
	//that you have an application that is going to download some data from the 
	//Web for example a smartphone application is going to fetch all the images
	//from Facebook.
	//Then we have to wait for that given stretch to finish its downloading 
	//related tasks in order to be able
	//to present it and show these images on the user interface.
	
	try {
		th1.join();
		th2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Finish the code after join");

}

}



