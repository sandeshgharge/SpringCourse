package com.example.dsaExamples;

public class RotatedSortedArray {
	
	/**
	 * Search in Rotated Sorted Array: Search for a target value in a rotated sorted array.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) return mid;
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) 
					right = mid - 1;
				else left = mid + 1;
			} else {
				if (nums[mid] < target && target <= nums[right])
					left = mid + 1;
				else right = mid - 1;
			}
		}
		return -1;
	}

}
