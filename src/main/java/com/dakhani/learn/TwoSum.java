package com.dakhani.learn;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/ Result:Your runtime beats 81.68% of
 * java submissions.
 * 
 * @author Sami Dakhani Created on Nov 9, 2016
 *
 */
public class TwoSum {

	private static int findIndexOf(final int[] nums, final int key,
			boolean second) {

		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			if (key == nums[i] && !second) {
				index = i;
				break;
			} else if (key == nums[i] && second) {
				second = false;
			}
		}

		return index;
	}

	public static void main(final String[] args) {

		int[] nums = { 3, 2, 4 };
		int target = 6;

		int[] result = twoSumOptimised(nums, target);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] twoSum(final int[] nums, final int target) {

		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}

		}

		return result;
	}

	public static int[] twoSumOptimised(final int[] nums, final int target) {

		int[] result = new int[2];
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);

		int i = 0;
		int j = sortedNums.length - 1;

		while (i <= j) {

			if (sortedNums[i] + sortedNums[j] == target) {

				int firstElem = sortedNums[i];
				int secondElem = sortedNums[j];

				result[0] = findIndexOf(nums, firstElem, false);
				result[1] = findIndexOf(nums, secondElem,
						firstElem == secondElem);

				break;

			} else if (sortedNums[i] + sortedNums[j] < target) {
				i++;
			} else {
				j--;
			}
		}

		return result;
	}

}
