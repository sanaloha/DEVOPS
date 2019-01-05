package com.san.threads.examples;


//sequential example

	class Runner1{
		public void startrunning(){
			
			for(int i=0;i<10;i++){
				
				System.out.println("runner 1 " + i);
				
			}
		}
		
	}

	class Runner2{
		public void startrunning(){
			
			for(int i=0;i<10;i++){
				
				System.out.println("runner 2 " + i);
				
			}
		}
		
	}
	
public class Test {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner1 runner1 = new Runner1();
		Runner2 runner2 = new Runner2();
		
		runner1.startrunning();
		runner2.startrunning();

	}

}
