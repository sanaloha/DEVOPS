package com.san.threads.examples;



class Worker implements Runnable{
	
	//do not get stored in the cache
	//Main Memory=> Cache1=>CPU1=>thread1
	//Main Memory=> Cache2=>CPU2=>thread2
	private volatile boolean isTerminated = false;

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public void run() {
		
		while(!isTerminated){
			System.out.println("Hello from worker volatile ex");
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	
	
}
public class Test5Volatile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Worker worker  = new Worker();
		Thread th1 = new Thread(worker);
		th1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		
		System.out.println("Finished");
		
		

	}

}
