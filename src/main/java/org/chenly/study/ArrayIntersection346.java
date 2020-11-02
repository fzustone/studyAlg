package org.chenly.study;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author chenly
 * @create 2020-11-02 20:54
 */
public class ArrayIntersection346 {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 4,9,5};
		int[] nums2 = new int[] {9,4,9,8,4 };

		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {

		return Arrays.stream(nums1)
				.filter(num -> Arrays.stream(nums2)
						.anyMatch(num2 -> num2 == num))
				.distinct()
				.toArray();

	}

}
