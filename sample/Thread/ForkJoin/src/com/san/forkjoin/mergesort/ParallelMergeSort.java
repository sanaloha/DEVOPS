package com.san.forkjoin.mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction{

	
	private int[] nums;
	
	ParallelMergeSort(int[] nums){
		this.nums = nums;
	}
	@Override
	protected void compute() {
		
		if(nums.length <=10){
			mergeSort(nums);
			return;
		}
		int middleIndex = nums.length / 2;

		int[] leftSubArr = Arrays.copyOfRange(nums, 0, middleIndex);
		int[] rightSubArr = Arrays.copyOfRange(nums, middleIndex, nums.length);
		
		ParallelMergeSort leftTask = new ParallelMergeSort(leftSubArr);
		ParallelMergeSort rightTask = new ParallelMergeSort(rightSubArr);
		
		invokeAll(leftTask,rightTask);
		merge(leftSubArr,rightSubArr,nums);
	}
	
	public void mergeSort(int[] temp) {

		if (temp.length <= 1)
			return;

		int middleIndex = temp.length / 2;

		int[] left = Arrays.copyOfRange(temp, 0, middleIndex);
		int[] right = Arrays.copyOfRange(temp, middleIndex, temp.length);
		mergeSort(left);
		mergeSort(right);
		merge(left, right, temp);
	}

	private void merge(int[] leftSubArr, int[] rightSubArr, int[] originalArr) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < leftSubArr.length && j < rightSubArr.length) {
			if (leftSubArr[i] <= rightSubArr[i])
				originalArr[k++] = leftSubArr[i++];
			else
				originalArr[k++] = rightSubArr[j++];

		}
		while (i < leftSubArr.length) {
			originalArr[k++] = leftSubArr[i++];
		}

		while (j < rightSubArr.length)
			originalArr[k++] = rightSubArr[j++];

	}


}
