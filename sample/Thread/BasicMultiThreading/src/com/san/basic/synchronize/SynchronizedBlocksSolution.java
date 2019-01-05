package com.san.basic.synchronize;


/**
 * 
 * TO overcome the problem with intrinsic class lock. We can define two instances of class
 * object and use as locks in synchronized blocks.
 * 
 * This is the easiest solution and because they are locking on different objects it
 * may happen that thread one running this code and thread 2 running this code
 * 
 * They don't have to wait for each other because we don't get the class intrinsic lock we just
 * created two locks like lock1 and lock2 and whenever we make add or add again operation where 
 * we lock on different objects and that's why it's going to be much faster because threads do
 * not have to wait for each other when they are doing independent operations.
 * And this is what's happening here incrementing count 1 and incrementing count 2 has nothing to do
 * with each other.
 * They are totally independent from each other.
 * 
 * **/
public class SynchronizedBlocksSolution {
	
	private static int count1 = 0;
	private static int count2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public  static void add() {
		synchronized (lock1) {
			++count1;
		}
		
	}

	public  static void addAgain() {
		synchronized (lock2) {
		++count2;
		}
	}

	public static void compute() {
		for (int i = 0; i < 100; i++) {
			add();
			addAgain();
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();

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

		System.out.println("Count1 " +count1 +"- Count2 " + count2);
	}

}
