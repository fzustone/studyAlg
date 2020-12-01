package org.chenly.study.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author chenly
 * @create 2020-12-01 21:03
 */
public class SelectionSort {
	public static void main(String[] args) {

		System.out.println(Arrays.toString(sort(new int[] { 5, 6, 3, 2, 9, 1 })));
	}

	public static int[] sort(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}

			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;

		}
		return nums;
	}
}
