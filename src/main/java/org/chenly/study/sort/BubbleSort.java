package org.chenly.study.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author chenly
 * @create 2020-12-01 20:38
 */
public class BubbleSort {
	public static void main(String[] args) {

		System.out.println(Arrays.toString(sort(new int[] { 5, 6, 3, 2, 9, 1 })));
	}

	/*public static int[] sort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}*/

	public static int[] sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
}
