package com.san.parallel.parallelsum;

public class ParallelWorker extends Thread{
	
	private int[] nums;
	private int low;
	private int high;
	private int partialSum;
	
	
	public int getPartialSum() {
		return partialSum;
	}

	public ParallelWorker(int[] nums, int low, int high) {
		this.nums = nums;
		this.low = low;
		this.high = high;
	}
	
	@Override
	public void run() {
		partialSum = 0;
		
		for(int i =low; i <= high;i++)
			partialSum = partialSum + nums[i];
	}

}
