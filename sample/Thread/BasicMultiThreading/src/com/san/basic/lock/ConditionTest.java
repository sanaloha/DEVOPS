package com.san.basic.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WorkerEx{
	
	private static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition() ;
	
	public void produce() throws InterruptedException{
		
		
		lock.lock();
		
		System.out.println("producer");
		
		condition.await();
		
		System.out.println("producer again");
		lock.unlock();
		
	}
	
	
	
	public void consume() throws InterruptedException{
		
		lock.lock();
		Thread.sleep(2000);
		System.out.println("Consumer");
		condition.signal();
		lock.unlock();
		
		
	}
}


public class ConditionTest {

	

	public static void main(String[] args) {
		WorkerEx  worker = new WorkerEx();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					worker.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					worker.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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

	}

}
