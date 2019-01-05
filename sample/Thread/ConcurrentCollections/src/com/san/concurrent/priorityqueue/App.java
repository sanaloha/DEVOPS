/**
 * 
 */
package com.san.concurrent.priorityqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueue !!!
 * 
 * It implements the BlockingQueue interface
 * 
 * -unbounded concurrent queue -It uses the same ordering rule as the
 * java.util.PriorityQueue Class -> Have to implement the Comparable interface
 * The Comparable interface will determine what will be the order in the queue
 * 
 * The priority can be the same compare() == 0 case
 * 
 * no null items!!!
 * 
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		
		new Thread(new FirstWorker(queue)).start();
		new Thread(new SecondWorker(queue)).start();
		
		/**If I run it that is priority queue is going to store the person objects sorted according to the person
		that name.As you can see it's going to be the alphabetical ordering according to the name parameter.
		Adam Daniel Joe Cavenaugh Well what if we would like to sort them according to the age parameter.
		Of course we just have to modify this compared to I think integer. **/

	}

}

class FirstWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public FirstWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		try {
			System.out.println("Add to the Queue...");
			blockingQueue.put("B");
			blockingQueue.put("A");
			blockingQueue.put("H");
			Thread.sleep(1000);
			blockingQueue.put("G");
			Thread.sleep(1000);
			blockingQueue.put("F");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class SecondWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public SecondWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
			System.out.println(" take " + blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(" take " + blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(" take " + blockingQueue.take());
			System.out.println(" take " + blockingQueue.take());
			System.out.println(" take " + blockingQueue.take());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}


class Person implements Comparable<Person>{
	
	private int age;
	private String name;

	public Person(int age, String name){
		
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Person otherPerson) {
		
		return name.compareTo(otherPerson.getName());
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name + "-" + age;
		
	}
	
	
}