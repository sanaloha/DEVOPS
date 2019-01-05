package com.san.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*****
 * Latch-> Multiple Threads can wait each other
 * 
 * A cyclic barriers used in a situation where u want to create group of tasks
 * 	to perform work in parallel + wait until they are all finished before
 * 		moving on to the next step
 * 		-> something like join
 * 		-> something like CountDownLatch
 * 
 * 		CountDownLatch: one shot event
 * 		CyclicBarrier: it can be reused over and over again
 * 
 * 			+ CyclicBarrier has a barrier action: a runnable that will run automatically
 * 				when the count reaches zero !!!
 * 
 * 		new CyclicBarrier(N)-> N threads will wait for each other
 * 		
 *  WE CANNOT REUSE LATCHES BUT WE CAN REUSE CYCLIC BARRIERE -> reset() !!!
 * 
 **/
public class App {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable(){

			@Override
			public void run() {
				System.out.println("All the tasks are finished");
				
			}
			
		});
		
		for(int i=0; i<5;i++)
			executorService.execute(new Worker(i+1, barrier));
		
		executorService.shutdown();
		
	}

}

class Worker implements Runnable{
	
	private int id;
	private CyclicBarrier cyclicBarrier;
	private Random random;

		public Worker(int id, CyclicBarrier cyclicBarrier){
			
			this.id = id;
			this.random = new Random();
			this.cyclicBarrier = cyclicBarrier;
			
			
		}
	@Override
	public void run() {
		
		doWork();

	}
	
	private void doWork() {
		System.out.println("Thread with id " +(id) + " working");
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread with id " +(id) + " Finished!!!");
		
			try {
				cyclicBarrier.await();
				System.out.println("After await===");
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public String toString(){
		
		return " "+this.id;
		
	}
}
