package org.chenly.study;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author chenly
 * @create 2021-06-27 20:43
 */
public class RemoveNthFromEnd19 {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;

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
		removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))),2);
		System.out.println("");
	}
}