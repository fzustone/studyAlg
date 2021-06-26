package org.chenly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author chenly
 * @create 2021-06-25 19:04
 */
public class ThreeSum15 {

	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		int length = nums.length;
		if (length <= 2) {
			return lists;
		}
		int[] ints = Arrays.stream(nums)
				.sorted()
				.toArray();
		for (int i = 0; i < length; i++) {
			if (i > 0 && ints[i] == ints[i - 1]) {
				continue;
			}
			if (ints[i] > 0) {
				break;
			}

			int sum = ints[i];
			int l = i + 1, r = length - 1;
			while (l < r) {
				int lr = ~(ints[l] + ints[r]) + 1;

				if (lr == sum) {
					lists.add(Arrays.asList(sum, ints[l], ints[r]));
					l++;
					r--;
					continue;
				}

				if (lr > sum) {
					l++;
				} else {
					r--;
				}

			}
		}
		//得到的重复list是从小到大排好顺序，所以可以直接distinct掉
		return lists.stream()
				.distinct()
				.collect(Collectors.toList());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int length = nums.length;

		if (length <= 2) {
			return new ArrayList<>();
		}

		int[] sortNum = Arrays.stream(nums)
				.sorted()
				.toArray();

		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			if (i > 0 && sortNum[i - 1] == sortNum[i]) {
				continue;
			}
			if (sortNum[i] > 0) {
				break;
			}
			int l = i + 1, r = length - 1;
			while (l < r) {
				int left = sortNum[l];
				int right = sortNum[r];
				int sum = left + right + sortNum[i];
				if (sum == 0) {
					res.add(Arrays.asList(sortNum[i], left, right));

					while (left == sortNum[l] && l < r) {
						l++;
					}
					while (right == sortNum[r] && l < r) {
						r--;
					}
				} else if (sum > 0) {
					r--;
				} else {
					l++;
				}
			}

		}

		return res;

	}

	public static void main(String[] args) {
		//[3,0,3,2,-4,0,-3,2,2,0,-1,-5]
		int[] aaa = new int[] { 0, 0, 0 };

		System.out.println(threeSum(aaa));
	}
}
