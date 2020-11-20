package org.chenly.study;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * @author chenly
 * @create 2020-11-19 19:50
 */
public class BinarySearch704 {
	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] ints = new int[] { 1, 2, 3, 4, 5, 6, 7, 9 };

		System.out.println(search(ints, 5));
	}

}
