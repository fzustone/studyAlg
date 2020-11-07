package org.chenly.study;

/**
 * 反转链表:https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 个人思路记录：https://chenliny.com/archives/503/
 * @author chenly
 * @create 2020-11-06 22:39
 */
public class ReverseLinkedList {

	public static class ListNode {
		int val;

		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, new ListNode(3, new ListNode(6, new ListNode(0))));

		//System.out.println(reverser(node1));

		//System.out.println(reverser2(node1));

		System.out.println(reverser3(node1));

		System.out.println("");
	}

	/**
	 * 迭代双链表
	 */
	private static ListNode reverser(ListNode head) {
		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;

			prev = current;
			current = temp;
		}
		return prev;
	}

	/**
	 * 递归实现双链表
	 */
	private static ListNode reverser2(ListNode head) {

		return reverseRecursion(null, head);
	}

	private static ListNode reverseRecursion(ListNode prev, ListNode current) {
		if (current == null) {
			return prev;
		}
		ListNode temp = current.next;
		current.next = prev;
		return reverseRecursion(current, temp);

	}

	/**
	 * 从后往前递归
	 */
	private static ListNode reverser3(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode afterReverse = reverser3(head.next);

		head.next.next = head;
		head.next = null;
		return afterReverse;

	}
}
