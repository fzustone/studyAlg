package org.chenly.study;

import java.util.*;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author chenly
 * @create 2021-06-29 21:01
 */
public class IsValid20 {

	public static boolean isValid(String s) {
		if ((s.length() & 1) == 1) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().equals(map.get(c))) {
				stack.pop();
				continue;
			}
			stack.push(c);
		}
		return stack.size() == 0;
	}

	public static void main(String[] args) {
		System.out.println(isValid("({}"));
		System.out.println(isValid("{[]}"));
		System.out.println(isValid("([)]"));
	}
}
