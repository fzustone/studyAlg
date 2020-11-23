package org.chenly.study.swordoffer;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @author chenly
 * @create 2020-11-23 19:31
 */
public class RebuildTree7 {
	//个人琢磨的解法 不够优秀
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int length = preorder.length;
		if (length == 0) {
			return null;
		}
		TreeNode treeNode = new TreeNode(preorder[0]);
		int rootNum = 0;

		for (int i = 0; i < length; i++) {
			if (preorder[0] == inorder[i]) {
				rootNum = i;
				break;
			}
		}

		int[] leftPreorder = new int[rootNum];
		int[] leftInorder = new int[rootNum];

		int[] rightPreorder = new int[length - 1 - rootNum];
		int[] rightInorder = new int[length - 1 - rootNum];

		for (int i = 0; i < rootNum; i++) {
			leftInorder[i] = inorder[i];
			leftPreorder[i] = preorder[i + 1];
		}
		for (int i = 0; i < length - 1 - rootNum; i++) {
			rightInorder[i] = inorder[i + 1 + rootNum];
			rightPreorder[i] = preorder[i + 1 + rootNum];
		}

		treeNode.left = buildTree(leftPreorder, leftInorder);
		treeNode.right = buildTree(rightPreorder, rightInorder);
		return treeNode;

	}

	//最优解
	public static TreeNode buildTree2(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		//<num->index>
		HashMap<Integer, Integer> inorderMap = new HashMap<>(inorder.length * 3 % 2);

		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}

		return buildTreeInternal(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);

	}

	private static TreeNode buildTreeInternal(int[] preorder, int pl, int pr, int[] inorder, int il, int ir,
			HashMap<Integer, Integer> inorderMap) {

		if (pl > pr) {
			return null;
		}

		int root = preorder[pl];
		TreeNode treeNode = new TreeNode(root);
		int rootPos = inorderMap.get(root);

		//注意理解rootPos-il的含义 表示inorder中序遍历中到第一个节点的距离
		treeNode.left = buildTreeInternal(preorder, pl + 1, pl + (rootPos - il), inorder, il, rootPos - 1, inorderMap);
		treeNode.right = buildTreeInternal(preorder, pl + (rootPos - il) + 1, pr, inorder, rootPos + 1, ir, inorderMap);

		return treeNode;

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		TreeNode treeNode = buildTree2(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 }, new int[] { 4, 7, 2, 1, 5, 3, 8, 6 });
		System.out.println("");
	}
}
