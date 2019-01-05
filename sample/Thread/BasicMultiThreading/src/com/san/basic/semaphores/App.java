package com.san.basic.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * -Semaphore maintains a set of permits 
 * acquire() -> if a permit is available then take it 
 * release() -> adds a permit
 * 
 * semaphore just keeps a count of the number of resources available
 *  * semaphore(int permit, boolean fair)
 * 
 **/

enum Downloader {

	INSTANCE;
	private Semaphore semaphore = new Semaphore(3, true);

	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	private void download() {
		System.out.println("Download data from the web");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class App {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 12; i++) {
			executorService.execute(new Runnable() {
				public void run() {
					Downloader.INSTANCE.downloadData();
				}

			});

		}

	}

}
