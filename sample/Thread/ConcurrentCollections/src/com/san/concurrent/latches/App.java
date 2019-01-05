package com.san.concurrent.latches;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/***
*This is used to synchronize one or more tasks by forcing them to wait for the completion
*	of a set of operations being performed by other tasks.
*	-So you give an initial count to the countdownLatch Object and any task that calls await()
*		 on that object will be blocked until the counter which is zero.
*	-other tasks may call countDown() on the object to reduce the count, Presumably when a task finishes it job
*	-**a countDownLatch-> cannot be reset it's very important.
*		so if you need a version that reset the count you have to use cyclic barrier instead.
*	-The task that called countDown() are not blocked when they make that call, only the call to await() is a blocked until the count reaches zero
*		
*		The typical use is to divide the problem into n independently task and create a CountDownLatch with a value of N
*		when each task is finished it calls countDown on the latch. Tasks waiting for the problem to be solved call await()
*		on the latch to hold themselves back until it is completed.
*		
*		For example: You want to download something after 10000, users download an image.
*		
* 
* ***/
public class App {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		CountDownLatch latch = new CountDownLatch(5);
		
		for(int i=0; i<5;i++)
			executorService.execute(new Worker(i, latch));
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Done===============");
		
		executorService.shutdown();

	}

}


class Worker implements Runnable{
	
	private int id;
	private CountDownLatch CountDownLatch;
	private Random random;

		public Worker(int id, CountDownLatch CountDownLatch){
			
			this.id = id;
			this.CountDownLatch = CountDownLatch;
			
			
		}
	@Override
	public void run() {
		
		doWork();
		
		CountDownLatch.countDown();
		
		
	}
	private void doWork() {
		System.out.println("Thread with id " +(id+1) + " working");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}