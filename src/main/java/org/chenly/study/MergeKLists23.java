package org.chenly.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author chenly
 * @create 2021-07-13 20:09
 */
public class MergeKLists23 {
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(a -> a.val));

		ListNode head = new ListNode(-1);
		ListNode cur = head;

		Arrays.stream(lists)
				.filter(Objects::nonNull)
				.forEach(queue::add);

		while (!queue.isEmpty()) {
			ListNode poll = queue.poll();
			cur.next = poll;
			cur = cur.next;
			if (poll.next != null) {
				queue.add(poll.next);
			}

		}
		return head.next;
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


		mergeKLists(new ListNode[]{null});
	}
}
