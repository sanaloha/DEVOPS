/**
 * 
 */
package com.san.forkjoin;

import java.util.concurrent.ForkJoinPool;

import com.san.forkjoin.SimpleRecursiveAction;

/**
 * fork() asynchronously execute the given task in a pool we can call this on
 * RecursiveAction or RecursiveTask<T>
 * 
 * join() returns the result of a computation when it is done
 *
 * invoke() Execute the given task + return its result on completion
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// get the available processor
		//is going to contain as many threads as the number of available processors. And this is what we want to do.
		//We don't want to create more threads than the number of processors because then it's not going to be parallel.
		//It's going to be a multi-threaded execution but it's not going to be parallel.
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		SimpleRecursiveAction simpleRecAction = new SimpleRecursiveAction(110);
		pool.invoke(simpleRecAction);

	}

}
