package org.chenly.study;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 33. 搜索旋转排序数组
 *
 * @author chenly
 * @create 2021-07-17 12:30
 */
public class Search33 {

	public static int search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > nums[right]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {

				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}

			}
		}

		return -1;
	}

	public static void main(String[] args) {

		System.out.println(search(new int[] { 1, 3 }, 3));
		System.out.println(search(new int[] { 3, 5, 8, 56, 1, 2 }, 56));
	}
}
