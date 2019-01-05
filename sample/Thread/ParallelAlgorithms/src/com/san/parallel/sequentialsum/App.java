/**
 * 
 */
package com.san.parallel.sequentialsum;

import java.util.Random;

/**
 * @author 311832
 *
 */
public class App {

	public static void main(String[] args) {

		Random random = new Random();
		SequentialSum seqSum = new SequentialSum();
		
		int[] nums = new int[10000000];
		
		for(int i=0;i < nums.length; ++i){
			nums[i] = random.nextInt(100);
		}
		
		long start = System.currentTimeMillis();
		
		System.out.println(seqSum.sum(nums));
		System.out.println("Sequential takes " + (System.currentTimeMillis() - start) + " millis");
		
		
		

	}

}
