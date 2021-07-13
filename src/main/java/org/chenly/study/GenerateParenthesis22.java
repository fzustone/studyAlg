package org.chenly.study;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author chenly
 * @create 2021-06-30 19:25
 */
public class GenerateParenthesis22 {
	public static List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<>();

		dfs(res, "", n, 0, 0);

		return res;
	}

	private static void dfs(List<String> res, String str, int n, int left, int right) {
		if (left > n || right > n || left < right) {
			return;
		}
		if (left == right && left + right == 2 * n) {
			res.add(str);
			return;
		}
		if (str.length() == 2 * n) {
			return;
		}

		dfs(res, str + "(", n, left + 1, right);

		dfs(res, str + ")", n, left, right + 1);

	}

	public static void main(String[] args) {

		List<String> list = generateParenthesis(5);
		System.out.println(list.stream()
				.sorted()
				.distinct()
				.collect(Collectors.joining(",")));
		System.out.println("aaaa");
		System.out.println(Arrays.stream(
				"((((())))),(((()()))),(((())())),(((()))()),(((())))(),((()(()))),((()()())),((()())()),((()()))(),((())(())),((())()()),((())())(),((()))(()),((()))()(),(()((()))),(()(()())),(()(())()),(()(()))(),(()()(())),(()()()()),(()()())(),(()())(()),(()())()(),(())((())),(())(()()),(())(())(),(())()(()),(())()()(),()(((()))),()((()())),()((())()),()((()))(),()(()(())),()(()()()),()(()())(),()(())(()),()(())()(),()()((())),()()(()()),()()(())(),()()()(()),()()()()()".split(
						","))
				.sorted()
				//.filter(a -> !list.contains(a))
				.collect(Collectors.joining(",")));
	}
}
