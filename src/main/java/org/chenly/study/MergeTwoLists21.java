package org.chenly.study;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author chenly
 * @create 2021-06-26 23:28
 */
public class MergeTwoLists21 {
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		//用一个新的链表装排序后的链表
		ListNode newNode = new ListNode();
		ListNode temp = newNode;
		while (true) {
			//循环结束其中一个只需要把剩下的指向新链表末尾即可
			if (l1 == null) {
				temp.val = l2.val;
				temp.next = l2.next;
				break;
			}
			if (l2 == null) {
				temp.val = l1.val;
				temp.next = l1.next;

				break;

			}

			if (l1.val >= l2.val) {
				temp.val = l2.val;
				l2 = l2.next;
			} else {
				temp.val = l1.val;
				l1 = l1.next;
			}
			temp.next = new ListNode();
			temp = temp.next;
		}
		return newNode;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

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

	//官方迭代
	public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9, new ListNode(3));
		ListNode l2 = new ListNode(5, new ListNode(7));

		System.out.println(mergeTwoLists(l1, l2));
		System.out.println("");
	}
}
