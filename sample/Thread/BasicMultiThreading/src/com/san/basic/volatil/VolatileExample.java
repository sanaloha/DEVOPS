package com.san.basic.volatil;

/**
 * Every read of a volatile variable will be read from a RAM so from the main memory
 * not from cache, usually variables are cached for performance reason
 * 
 * Caches are faster: Do not use Volatile variables if not necessary.
 * It prevents instructions reordering which is a performance boost technique 
 * 
 * We have main memory several cpu's and each cpu is associated with a cache, which can store variable.
 * CPU can access the cache much faster than main memory, so frequently used variables are stored in cache.
 * main memory ---> cache-cpu1 th1   here cpu1 is running the 1st thread
 * 			   ---> cache-cpu2 th2   here cpu2 is running the 2nd thread
 * 
 * 
 * **/


class Worker implements Runnable{

	private volatile boolean  isTerminated = false;
	
	
	public boolean isTerminated() {
		return isTerminated;
	}


	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}


	@Override
	public void run() {
		
		while(!isTerminated){
			System.out.println("Hello From the worker class");
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
}
public class VolatileExample {
	
	
	
	public static void main(String[] args) {
		Worker worker = new Worker();
		
		Thread t1 = new Thread(worker);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		System.out.println("Finished...........");
		
	}

}
