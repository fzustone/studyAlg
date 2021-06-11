package org.chenly.study;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author chenly
 * @create 2021-06-11 18:59
 */
public class LengthOfLongestSubstring3 {
	public static int lengthOfLongestSubstring(String s) {
		int l = 0, r = 0;
		int max = 0;
		Set<Character> temp = new HashSet<>();
		char[] chars = s.toCharArray();
		while (l <= r && r < s.length()) {
			if (temp.contains(chars[r])) {
				temp.remove(chars[l]);
				max = Math.max(r - l, max);
				l++;
				continue;
			}

			temp.add(chars[r]);
			r++;

		}
		return Math.max(r - l, max);
	}

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("bbbbbb"));
	}

}
