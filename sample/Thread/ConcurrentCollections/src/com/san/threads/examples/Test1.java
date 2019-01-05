package com.san.threads.examples;

	
		class RunnerTh1 implements Runnable{
			
			public void startrunning(){
				
				for(int i=0;i<10;i++){
					
					System.out.println("runner 1 " + i);
					
				}
			}

			@Override
			public void run() {
				this.startrunning();
			}
			
		}

		class RunnerTh2 implements Runnable{
			public void startrunning(){
				
				for(int i=0;i<10;i++){
					
					System.out.println("runner 2 " + i);
					
				}
			}
			@Override
			public void run() {
				this.startrunning();
			}
			
		}
		
	public class Test1 {
		

		public static void main(String[] args) {
			
			Thread th1 = new Thread( new RunnerTh1());
			Thread th2 = new Thread( new RunnerTh2());
			
			th1.start();
			th2.start();

		}

	}



