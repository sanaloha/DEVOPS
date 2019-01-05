package com.san.basic.sequentialprocessing;


class Runner1{
	
	public void startRunning(){
	
		for(int i=0;i<10;i++){
			System.out.println("Runner1: " +(i+1));
			
		}
	
	}
}

class Runner2{
	
	public void startRunning(){
	
		for(int i=0;i<10;i++){
			System.out.println("Runner2: " +(i+1));
			
		}
	
	}
}

public class SequentialProcessing {

	public static void main(String[] args) {
	
		Runner1 run1 = new Runner1();
		Runner2 run2 = new Runner2();
		
		run1.startRunning();
		run2.startRunning();

	}

}
