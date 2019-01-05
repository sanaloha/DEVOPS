package com.san.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/***
 * With the help of exchangers -> 2 Threads can exchange Objects
 * 
 * exchange() exchanging objects is done via one of the two exchange() methods
 * 
 * For Example: genetics algorithms, training nueral networks
 * 
 ****/
public class App {

	public static void main(String[] args) {
		Exchanger<Integer> exchange = new Exchanger<>();
		
		new Thread(new Exchanger1(exchange)).start();
		new Thread(new Exchanger2(exchange)).start();

	}

}

class Exchanger1 implements Runnable {
	private int counter;

	private Exchanger<Integer> exchanger;

	public Exchanger1(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		System.out.println("Exchanger 1");
		while (true) {
			counter = counter + 1;
			System.out.println("First Thread incremented the Counter " + counter);

			try {
				this.exchanger.exchange(counter);

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Exchanger2 implements Runnable {
	private int counter;

	private Exchanger<Integer> exchanger;

	public Exchanger2(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		System.out.println("Exchanger 1");
		while (true) {
			counter = counter - 1;
			System.out.println("Second Thread Decrement the Counter " + counter);

			try {
				this.exchanger.exchange(counter);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
