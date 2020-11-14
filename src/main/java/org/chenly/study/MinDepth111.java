package org.chenly.study;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author chenly
 * @create 2020-11-14 11:41
 */
public class MinDepth111 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		//第一个节点入队
		queue.add(root);
		int deep = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = queue.poll();
				TreeNode left = treeNode.left;
				TreeNode right = treeNode.right;
				//判断是否叶子节点
				if (left == null && right == null) {
					return deep;
				}
				if (left != null) {
					queue.add(left);
				}
				if (right != null) {
					queue.add(right);
				}
			}
			//要在树深度层级进行层级+1
			deep++;
		}
		return deep;

	}

	public static void main(String[] args) {
		//TreeNode treeNode = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
		//[3,9,20,null,null,15,7]
		TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		System.out.println(minDepth(treeNode));
	}

}
