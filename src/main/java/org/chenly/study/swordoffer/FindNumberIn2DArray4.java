package org.chenly.study.swordoffer;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author chenly
 * @create 2020-11-05 19:30
 */
public class FindNumberIn2DArray4 {
	public static void main(String[] args) {
		/*int[][] array=new int[][]{
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};*/

		int[][] array = new int[][] { { -5 } };
		System.out.println(findNumberIn2DArray(array, -5));
	}

	/**
	 * 暴力解法，打平数组
	 */
	/*public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		return Arrays.stream(matrix)
				.map(Arrays::stream)
				.flatMap(IntStream::boxed)
				.anyMatch(num -> num == target);
	}*/

	/**
	 * 最优解
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = 0;
		int col = cols - 1;
		while (row < rows && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			}
			if (matrix[row][col] > target) {
				col = col - 1;
				continue;
			}
			if (matrix[row][col] < target) {
				row = row + 1;
			}

		}
		return false;
	}
}
