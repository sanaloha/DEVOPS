package com.san.basic.runnable;


class Runner5 extends Thread{
	
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

class Runner6 extends Thread{
	
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

public class ThreadExample {
	
	public static void main(String[] args) {
		
		Runner5 t1 = new Runner5();
		Runner5 t2 = new Runner5();
		
		t1.start();
		t2.start();
	
	}
	
}
