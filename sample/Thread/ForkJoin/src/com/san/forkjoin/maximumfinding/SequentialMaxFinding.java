package com.san.forkjoin.maximumfinding;

public class SequentialMaxFinding {

	// O[N]
	public int SequentialMaxFind(int[] nums, int highIndex) {

		int max = nums[0];

		for (int i = 1; i < highIndex; i++) {
			if (nums[i] > max) {
				max = nums[i];

			}
		}

		return max;

	}

}
