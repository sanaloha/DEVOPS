package com.san.forkjoin.mergesort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		//int nums[] ={1,5,4,4,-1,0,4,5,7,8,9};
		int nums[] = initializeNums();
		SequentialMergeSort seqMerge = new SequentialMergeSort();
		
		long start = System.currentTimeMillis();
		seqMerge.mergeSort(nums);
		System.out.println("Sequential Algorithm " + (System.currentTimeMillis() - start) + "ms");
		System.out.println();
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ParallelMergeSort task = new ParallelMergeSort(nums);
		start = System.currentTimeMillis();
			
		pool.invoke(task);
		
		System.out.println("Parallel Algorithm" + (System.currentTimeMillis() - start) + "ms");
		
		/*for(int i=0; i< nums.length;i++){
			System.out.print(nums[i] + " ");
		}*/
	}

	public static int[] initializeNums(){
		
		Random random = new Random();
		int[] num = new int[10000];
		
		for(int i=0; i< num.length;i++){
			num[i] = random.nextInt(1000);
		}
		return num;
	}
}
	