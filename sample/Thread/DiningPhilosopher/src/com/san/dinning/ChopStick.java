package com.san.dinning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

	private int id;
	private Lock lock;

	public ChopStick(int id) {

		this.id = id;
		this.lock = new ReentrantLock();
	}

	public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {

		if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(philosopher + " picked up " + state.toString() + "" + this);
			return true;

		}

		return false;

	}
	
	public void putDown(Philosopher philosopher, State state){
		
		lock.unlock();
		
		System.out.println(philosopher + " put down " + this);
		
	}
	
	@Override
	public String toString() {
	
		return "ChopStick " +id;
	}

}
