package com.san.basic.runnable;


class Runner3 implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("Runner1: " +(i+1));
		}
		
	}
}

class Runner4 implements Runnable{
	
			@Override
		public void run() {
			for(int i=0;i<10;i++){
				System.out.println("Runner2: " +(i+1));
			}
			
		}
	
	}

public class RunnableExample {
	
	
	public static void main(String[] args) {
	
		Thread run3 = new Thread(new Runner3());
		Thread run4 = new Thread(new Runner4());
		
		run3.start();
		run4.start();
	
	}

}
