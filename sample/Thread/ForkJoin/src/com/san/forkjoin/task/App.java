package com.san.forkjoin.task;

import java.util.concurrent.ForkJoinPool;

import com.san.forkjoin.SimpleRecursiveAction;
import com.san.forkjoin.task.SimpleRecursiveActionTask;

public class App {

	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveActionTask simpleRecAction = new SimpleRecursiveActionTask(110);
		System.out.println(pool.invoke(simpleRecAction));
		
	}

}
