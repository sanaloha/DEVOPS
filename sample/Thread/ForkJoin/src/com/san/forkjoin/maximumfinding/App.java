package com.san.forkjoin.maximumfinding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static int THRESHOLD=0;
	
	public static void main(String[] args) {
		int [] nums = initializeNums();
		
		THRESHOLD = nums.length/Runtime.getRuntime().availableProcessors();
		
		SequentialMaxFinding maxfindSeq = new SequentialMaxFinding();
		
		long start =  System.currentTimeMillis();
		
		System.out.println("Max= " + maxfindSeq.SequentialMaxFind(nums, nums.length));
		System.out.println("time taken for sequential processing= " + (System.currentTimeMillis() - start)+" ms");
		
		System.out.println();
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		ParallelMaxFinding maxfindPar = new ParallelMaxFinding(nums, 0, nums.length);
		
		start = System.currentTimeMillis();
		
		System.out.println("Max= " + pool.invoke(maxfindPar));
		System.out.println("time taken for parllel processing " +(System.currentTimeMillis()-start)+" ms");
	}

	private static int[] initializeNums() {
		
		Random random = new Random();
		
		int[] nums = new int[300000000];
		for(int i=0;i<300000000;i++){
			nums[i] = random.nextInt(1000); //random int in the range 0-1000
		}
		
		return nums;
	}

}
