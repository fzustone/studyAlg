package org.chenly.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author chenly
 * @create 2020-11-29 10:07
 */
public class TwoSum1 {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num1 = nums[i];
			int num2 = target - num1;
			if (map.containsKey(num2) && map.get(num2) != i) {
				return new int[] { map.get(num2), i };
			}
			map.put(num1, i);
		}
		return new int[0];

	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(twoSum(new int[] { -10, 7, 19, 15 }, 9)));
	}
}
