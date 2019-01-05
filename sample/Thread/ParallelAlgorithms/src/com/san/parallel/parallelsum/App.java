package com.san.parallel.parallelsum;

import java.util.Random;

import org.omg.SendingContext.RunTime;

/**
 * @author 311832
 *
 */
public class App {

	public static void main(String[] args) {

		Random random = new Random();
		int numOfThreads = Runtime.getRuntime().availableProcessors();
		System.out.println("no of processor" + numOfThreads);
		
		
		ParallelSum parSum = new ParallelSum(numOfThreads);
		
		int[] nums = new int[100000000];
		
		for(int i=0;i < nums.length; ++i){
			nums[i] = random.nextInt(100);
		}
		
		long start = System.currentTimeMillis();
		
		System.out.println(parSum.sum(nums));
		System.out.println("Sequential takes " + (System.currentTimeMillis() - start) + " millis");
		
		
		

	}

}
