package org.chenly.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author chenly
 * @create 2020-11-12 8:46
 */
public class RecoveryIp93 {

	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12) {
			return new ArrayList<>();
		}
		recursion(s, new LinkedList<>(), list);
		return list;
	}

	/**
	 * @param remainStr 当前剩余的字符串
	 * @param legalIpFragment 合法的IP片段List
	 * @param result 最终的结果集
	 */
	public static void recursion(String remainStr, LinkedList<String> legalIpFragment, List<String> result) {
		//两个条件：达到合法IP，即4个片段；没有剩余的字符串
		if (legalIpFragment.size() == 4 && remainStr.isEmpty()) {
			result.add(String.join(".", legalIpFragment));
			return;
		}

		//这里直接循环字符串的长度次，但是实际上会在isLegalIpFragment里的判断被break掉，也就是实际上绝对不会循环超过3次
		//主要是因为直接定死3次需要多一个判断，remainStr.substring(0, i)这里的越界问题
		for (int i = 1; i <= remainStr.length(); i++) {
			String ipFragment = remainStr.substring(0, i);
			if (!isLegalIpFragment(ipFragment, legalIpFragment)) {
				break;
			}
			legalIpFragment.add(ipFragment);
			recursion(remainStr.substring(i), legalIpFragment, result);
			legalIpFragment.removeLast();

		}

	}

	public static boolean isLegalIpFragment(String ipFragment, List<String> fragment) {

		if (fragment.size() >= 4) {
			return false;
		}

		if (ipFragment.length() > 1 && ipFragment.startsWith("0")) {
			return false;
		}
		return Long.parseLong(ipFragment) <= 255L;

	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("0000"));
	}

}
