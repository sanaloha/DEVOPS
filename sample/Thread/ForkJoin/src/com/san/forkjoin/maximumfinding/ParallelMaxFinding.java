package com.san.forkjoin.maximumfinding;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer> {

	private int[] nums;
	private int lowIndex;
	private int highIndex;

	public ParallelMaxFinding(int[] nums, int lowIndex, int highIndex) {

		this.nums = nums;
		this.lowIndex = lowIndex;
		this.highIndex = highIndex;
	}

	@Override
	protected Integer compute() {
		
		if(highIndex - lowIndex <App.THRESHOLD){ 
			//no need for parallel tasks
			return SequentialMaxFind(nums, highIndex);
		}else{
			
			int middleIndex = (lowIndex + highIndex)/2;
			ParallelMaxFinding task1 = new ParallelMaxFinding(nums, lowIndex, middleIndex);
			ParallelMaxFinding task2 = new ParallelMaxFinding(nums, lowIndex, middleIndex);
			//task1.fork();
			//task2.fork();
			
			//So basically this initial call is going to fork see it what does it mean that these tasks are going
			//to be executed in a parallel manner.
			//So they are inserted into the fork-join join pool and after that we have to return with them match.
			//maximum because we are looking for the maximum task of one to join and that task to join.
			invokeAll(task1, task2);
			
			return Math.max(task1.join(), task2.join());
			
		}
		
	}
	
	public int SequentialMaxFind(int[] nums, int highIndex) {

		int max = nums[lowIndex];

		for (int i = lowIndex+1; i < highIndex; i++) {
			if (nums[i] > max) {
				max = nums[i];

			}
		}

		return max;

	}

}
