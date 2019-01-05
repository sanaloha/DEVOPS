package com.san.forkjoin.task;

import java.util.concurrent.RecursiveTask;

import com.san.forkjoin.SimpleRecursiveAction;

public class SimpleRecursiveActionTask extends RecursiveTask<Integer> {

	private int simulatedWork;

	public SimpleRecursiveActionTask(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected Integer compute() {
		if (simulatedWork > 100) {
			// Create two subtask

			System.out.println("Parallel execution and split task " + simulatedWork);
			SimpleRecursiveActionTask task1 = new SimpleRecursiveActionTask(simulatedWork / 2);
			SimpleRecursiveActionTask task2 = new SimpleRecursiveActionTask(simulatedWork / 2);

			task1.fork();
			task2.fork();
			
			int solution = 0;
			solution += task1.join();
			solution += task2.join();
			return solution;

		} else {
			System.out.println("No parallel processing required, sequential algorith " + simulatedWork);
			return 2*simulatedWork;
		}

		
	}

}
