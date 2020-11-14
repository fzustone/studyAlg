package org.chenly.study;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 *
 * @author chenly
 * @create 2020-11-14 22:21
 */
public class OpenLock752 {
	public static int openLock(String[] deadends, String target) {
		if ("0000".equals(target)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.add("0000");

		Set<String> visited = new HashSet<>();
		Collections.addAll(visited, deadends);

		int rotations = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String poll = queue.poll();
				//不遍历已经走过的点
				if (visited.contains(poll)) {
					continue;
				}
				if (poll.equals(target)) {
					return rotations;
				}
				for (int j = 0; j < poll.length(); j++) {
					String nextNum = plusOne(poll, j);
					String nextNum2 = minOne(poll, j);

					//剔除存在的例如 0001 又回拨到0000的场景以及死亡锁
					if (!visited.contains(nextNum)) {
						queue.add(nextNum);
					}
					if (!visited.contains(nextNum2)) {
						queue.add(nextNum2);
					}

				}
				visited.add(poll);
			}
			rotations++;
		}
		return -1;

	}

	public static String plusOne(String num, int index) {
		char[] numChar = num.toCharArray();
		numChar[index] = numChar[index] == '9' ? '0' : ++numChar[index];
		return new String(numChar);
	}

	public static String minOne(String num, int index) {
		char[] numChar = num.toCharArray();
		numChar[index] = numChar[index] == '0' ? '9' : --numChar[index];
		return new String(numChar);
	}

	public static void main(String[] args) {
		System.out.println(
				openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));
	}
}
