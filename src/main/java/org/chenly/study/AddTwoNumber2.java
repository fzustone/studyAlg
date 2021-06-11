package org.chenly.study;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author chenly
 * @create 2021-06-11 19:39
 */
public class AddTwoNumber2 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode loop = new ListNode();
		ListNode r = loop;
		int yushu = 0;
		while (l1 != null || l2 != null || yushu != 0) {
			int a = 0;
			int b = 0;
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			}
			int sum = a + b + yushu;

			if (sum >= 10) {
				loop.val = sum - 10;
				yushu = 1;
			} else {
				loop.val = sum;
				yushu = 0;
			}
			if (l1 != null || l2 != null || yushu != 0) {
				loop.next = new ListNode();
			}
			loop = loop.next;
		}
		return r;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode listNode = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
				new ListNode(5, new ListNode(6, new ListNode(4))));
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}

}
