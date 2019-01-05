package com.san.parallel.mergesort.parallel;

public class MergeSort {

	private int[] nums = null;
	private int[] tempArray = null;

	public MergeSort(int[] nums) {

		this.nums = nums;
		this.tempArray = new int[nums.length];

	}
	
	
	public void parallelMergeSort(int low, int high, int numberOfThreads){
		
		if(numberOfThreads<=1){
			mergeSort(low, high);
			return;
		}
		
		int middle = (low + high) / 2;
		
		Thread leftSorter = mergeSortParallel(low, middle, numberOfThreads);
		Thread rightSorter = mergeSortParallel(middle+1, high, numberOfThreads);
		
		leftSorter.start();
		rightSorter.start();
		
		try {
			leftSorter.join();
			rightSorter.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		merge(low, middle, high);
		
	}
	
	private Thread mergeSortParallel(int low, int high, int numberOfThreads){
		
		return new Thread(){
			
			@Override
			public void run() {
				parallelMergeSort(low, high, numberOfThreads/2);
			}
			
		};
		
	}

	public void mergeSort(int low, int high) {

		if (low >= high)
			return;

		int middle = (low + high) / 2;

		mergeSort(low, middle);
		mergeSort(middle + 1, high);
		merge(low, middle, high);

	}

	private void merge(int low, int middle, int high) {

		// copy nums[i] to temp[i]
		for (int i = low; i < high; i++)
			tempArray[i] = nums[i];

		int i = low;
		int j = middle + 1;
		int k = low;

		// copy the smallest from either the left or the right side back
		// to the original array
		while ((i <= middle) && (j <= high)) {

			if (tempArray[i] <= tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			} else {
				nums[k] = tempArray[j];
				j++;
			}
			k++;
		}

		// copy the left side of the array into the target array.
		while (i <= middle) {
			nums[k] = tempArray[i];
			k++;
			i++;
		}
		// copy the right side of the array into the target array.
		while (j <= high) {
			nums[k] = tempArray[j];
			k++;
			j++;
		}

	}

	public void showResult() {
		for (int i = 0; i < nums.length; ++i) {
			System.out.print(nums[i] + " ");
		}

	}

}
