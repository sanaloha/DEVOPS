/**
 * 
 */
package com.san.parallel.mergesort.sequential;

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

		Random random = new Random();

		int[] nums = new int[30];

		for (int j = 0; j < nums.length; j++)
			nums[j] = random.nextInt(100) - 500;

		// o( nlogn)

		MergeSort sort = new MergeSort(nums);

		sort.mergeSort(0, nums.length - 1);
		sort.showResult();

	}

}
