package com.san.concurrent.blockingqueues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*****
 * 
 * BlockingQueue that represents a queue that is thread safe. put items or take
 * items from it
 * 
 * 
 * For Example: One thread putting items into the Q another Thread taking items
 * from it. at the same time!!! We can do with it producer-consumer pattern!!
 * 
 * put()-> putting items into the Q take()-> taking items from the Q
 * 
 * 
 * we don't have to use way that notify and low level of synchronization or locks for example.
 * This is why these classes and interfaces have came to be in order to implement these techniques and
 * methods very very conveniently.
 *  
 ***/
public class App {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); //maximum 10 items can be put into the queue
		
		FirstWorker worker1 = new FirstWorker(queue);
		SecondWorker worker2 = new SecondWorker(queue);
		
		new Thread(worker1).start();
		new Thread(worker2).start();
		
	}

}

class FirstWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public FirstWorker(BlockingQueue blockingQueue) {

		this.blockingQueue = blockingQueue;

	}

	@Override
	public void run() {
		int counter = 0;

		while (true) {
			try {
				blockingQueue.put(counter);
				System.out.println("putting items to the Queue " +counter);
				counter++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

class SecondWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public SecondWorker(BlockingQueue blockingQueue) {

		this.blockingQueue = blockingQueue;

	}

	@Override
	public void run() {

		while (true) {
			try {
				int number = blockingQueue.take();
				System.out.println("Getting  items from the Queue " +number);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
