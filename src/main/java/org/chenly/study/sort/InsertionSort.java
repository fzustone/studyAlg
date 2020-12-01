package org.chenly.study.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author chenly
 * @create 2020-12-01 22:10
 */
public class InsertionSort {
	public static void main(String[] args) {

		System.out.println(Arrays.toString(sort2(new int[] { 5, 6, 3, 2, 9, 1 })));
	}

	//自己看了算法思路之后的做法
	public static int[] sort(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			int j = i + 1;
			int k = i;
			while (k >= 0 && nums[j] < nums[k]) {
				int temp = nums[j];
				nums[j] = nums[k];
				nums[k] = temp;
				j = k;
				k = k - 1;
			}

		}
		return nums;
	}

	public static int[] sort2(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			int preIndex = i - 1;
			int current = nums[i];
			while (preIndex >= 0 && nums[preIndex] > current) {
				nums[preIndex + 1] = nums[preIndex];
				preIndex = preIndex - 1;
			}

			nums[preIndex + 1] = current;
		}
		return nums;
	}
}
