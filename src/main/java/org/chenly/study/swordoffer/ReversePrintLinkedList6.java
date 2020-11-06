package org.chenly.study.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author chenly
 * @create 2020-11-06 21:36
 */
public class ReversePrintLinkedList6 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, new ListNode(3, new ListNode(6, new ListNode(0))));

		ListNode node2 = new ListNode(2);
		System.out.println(Arrays.toString(reversePrint(node1)));
	}
	/*
		//递归
	public static int[] reversePrint(ListNode head) {

		List<Integer> a = new ArrayList<>();
		reverse(head, a);

		return a.stream()
				.mapToInt(Integer::intValue)
				.toArray();

	}

	public static void reverse(ListNode start, List<Integer> a) {
		if (start != null) {
			if (start.next != null) {
				reverse(start.next, a);

			}
			a.add(start.val);
		}

	}*/

	public static int[] reversePrint(ListNode head) {
		int count = 0;

		ListNode temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		int[] ints = new int[count];

		int tempCount = count;
		while (head != null) {
			tempCount--;
			ints[tempCount] = head.val;
			head = head.next;
		}

		return ints;
	}
}
