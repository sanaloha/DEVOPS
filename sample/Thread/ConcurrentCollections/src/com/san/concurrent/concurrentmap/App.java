package com.san.concurrent.concurrentmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/***
 * 
 * 
 * 
 * */
public class App {

	public static void main(String[] args) {

		ConcurrentMap<String, Integer> conMap = new ConcurrentHashMap<>();
		new Thread(new MapWorker1(conMap)).start();
		new Thread(new MapWorker2(conMap)).start();
		
		//other synchronized collection
		List<String> list1 = new ArrayList<>();
		List<String> list2 = Collections.synchronizedList(list1);

	}

}

class MapWorker1 implements Runnable {
	ConcurrentMap<String, Integer> concurrentMap;

	public MapWorker1(ConcurrentMap<String, Integer> concurrentMap) {
		this.concurrentMap = concurrentMap;
	}

	@Override
	public void run() {

		System.out.println("puttig into the Map");
		concurrentMap.put("A", 1);
		concurrentMap.put("F", 2);
		concurrentMap.put("C", 4);
		concurrentMap.put("E", 6);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MapWorker2 implements Runnable {
	ConcurrentMap<String, Integer> concurrentMap;

	public MapWorker2(ConcurrentMap<String, Integer> concurrentMap) {
		this.concurrentMap = concurrentMap;
	}

	@Override
	public void run() {

		System.out.println("getting from the Map");
		try {
			Thread.sleep(3000);
			System.out.println(concurrentMap.get("A"));
			System.out.println(concurrentMap.get("F"));
			Thread.sleep(4000);
			System.out.println(concurrentMap.get("E"));

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
