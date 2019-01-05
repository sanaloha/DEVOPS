package com.san.forkjoin.mergesort;

import java.util.Arrays;

public class SequentialMergeSort {

	public void mergeSort(int[] nums) {

		if (nums.length <= 1)
			return;

		int middleIndex = nums.length / 2;

		int[] left = Arrays.copyOfRange(nums, 0, middleIndex);
		int[] right = Arrays.copyOfRange(nums, middleIndex, nums.length);
		mergeSort(left);
		mergeSort(right);
		merge(left, right, nums);
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
