/**
 * 
 */
package com.san.parallel.mergesort.parallel;

import java.util.Random;

/**
 * @author 311832
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfThreads = Runtime.getRuntime().availableProcessors();
		
		
		int[] nums = { 4, 2, 6, 5, 44, 78, -4, 0, 1 };

		MergeSort sort = new MergeSort(nums);
		
		System.out.println(numberOfThreads);
		sort.parallelMergeSort(0, nums.length-1, numberOfThreads);
		sort.showResult();

	}

}
