package com.san.threads.examples;


/**
 * Class Intrinsic locks
 * Test Synchronization
 * 
 * **/
public class Test4 {

	public static int count1 = 0;
	public static int count2 = 0;
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	/* Clauss intrinsically Scenario-1
	 * 
	 *
	 * 
	 * public static synchronized void addCounter1(){
		count1++;
		
	}
	public static synchronized void addCounter2(){
		count2++;
		
	}*/
	/* Clauss intrinsically intrinsically Scenario-2
	 * 
	public static  void addCounter1(){
	
	synchronized(TestSync2.class){
		count1++;
		}
		
	}
	public static  void addCounter2(){
	synchronized(TestSync2.class){
		count2++;
		}
		
	}
	
	**/
	
/**Solution
 * And whenever we make some add or add again operation where we look on different objects and that's why
  it's going to be much faster because threads do not have to wait for each other when they are doing
  independent operations.
  And this is what's happening here incrementing Count 1 and incrementing count 2 has nothing to do
  with each other.
  They are totally independent from each other.
  So this is how we use synchronized blocks we can use it on the class but it is not advisable because
  then we get that class intrinsic lock and different threads cannot run different methods.
  So that's why we usually create these Lawks loquat and lock.
  And we use synchronize blocks like this.
 *  
 * **/

	
	public static  void addCounter1(){
		
		synchronized(lock1){
			count1++;
			}
			
		}
		public static  void addCounter2(){
		synchronized(lock2){
			count2++;
			}
			
		}
	
	public static void compute(){
		
		for(int i=0;i<1000;i++){
			
			addCounter1();
			addCounter2();
		}
	}
	public static void main(String[] args) {
		

		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<100;i++){
					//++counter;
					//synchronized
					addCounter1();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<100;i++){
					//++counter;
					//synchronized
					addCounter2();
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
		System.out.println("Count1 " + count1);	
		System.out.println("Count2 " + count2);

	}

}
