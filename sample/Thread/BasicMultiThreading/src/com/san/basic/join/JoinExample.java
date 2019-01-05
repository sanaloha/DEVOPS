package com.san.basic.join;



class Runner7 extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("Runner1: " +(i+1));
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class Runner8 extends Thread{
	
			@Override
		public void run() {
			for(int i=0;i<10;i++){
				System.out.println("Runner2: " +(i+1));
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	}
public class JoinExample {

	public static void main(String[] args) {
		Runner7 t1 = new Runner7();
		Runner8 t2 = new Runner8();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Task Finished");

	}

}
