package com.san.basic.waitnotify;

class Processor {

	public  void producer() throws InterruptedException {

		synchronized (this) {
			System.out.println("producer method..........");
			wait();
			System.out.println("Again producer method.....");

		}
	}

	public  void consumer() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("consumer method..........");
			notify();
			Thread.sleep(3000);

		}

	}

}

public class App {

	public static void main(String[] args) {

		Processor processor = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.consumer();
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
