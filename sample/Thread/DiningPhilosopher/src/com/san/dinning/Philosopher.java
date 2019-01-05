package com.san.dinning;

import java.util.Random;

public class Philosopher implements Runnable {

	private int id;
	private ChopStick leftChopStick;
	private ChopStick rightChopStick;
	private Random random;
	private int eatingCounter;
	private volatile boolean isFull = false;

	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {

		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;

		random = new Random();
	}

	@Override
	public void run() {
		try {

			while (!isFull) {
				thinking();
				if (leftChopStick.pickUp(this, State.LEFT)) {
					if (rightChopStick.pickUp(this, State.RIGHT)) {
						eating();
						rightChopStick.putDown(this, State.RIGHT);
					}
					rightChopStick.putDown(this, State.LEFT);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getCounter(){
		return this.eatingCounter;
	}
	public void setFull(boolean full) {

		this.isFull = full;
	}

	@Override
	public String toString() {

		return "Philosopher " + id;
	}

	public void thinking() throws InterruptedException {
		System.out.println("thinking");
		Thread.sleep(random.nextInt(1000));
	}

	public void eating()  throws InterruptedException{
		System.out.println("eating");
		this.eatingCounter++;
		Thread.sleep(random.nextInt(1000));
		
	}

}
