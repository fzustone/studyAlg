package org.chenly.study.swordoffer;

/**
 * @author chenly
 * @create 2020-11-04 22:15
 */
public class FindRepeatNumberInArray2 {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 3, 2, 4, 5 };
		System.out.println(findRepeatNumber(a));
	}
	//个人思路还是问题1一样的解法，但是时间空间复杂度不如最优解
	//最优解

	public static int findRepeatNumber(int[] nums) {

		int start = 1;
		int end = nums.length - 1;

		while (start <= end) {
			// >> 右移一位相当于除以2
			int middle = ((end + start) >> 1);
			int count = countRange(nums, start, middle);
			if (end == start) {
				if (count > 1) {
					return start;
				} else {
					break;
				}
			}
			if (count > (middle - start) + 1) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}

	public static int countRange(int[] nums, int start, int end) {
		int count = 0;
		for (int num : nums) {
			if (num >= start && num <= end) {
				count++;
			}
		}
		return count;
	}

}
