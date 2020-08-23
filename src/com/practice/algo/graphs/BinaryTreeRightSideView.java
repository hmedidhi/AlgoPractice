package com.practice.algo.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 **/
class TreeNode {
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

class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> result = new LinkedList<>();
		if (root == null)
			return result;
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			
			TreeNode element = queue.remove();
			if (element.left != null)
				queue.add(element.left);
			if (element.right != null)
				queue.add(element.right);
			if (!queue.isEmpty() && queue.peek() == null) {
				result.add(element.val);
				queue.remove();
				if (!queue.isEmpty())
					queue.add(null);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
		TreeNode node = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
		// TreeNode node = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3,
		// null, null));
		System.out.println(binaryTreeRightSideView.rightSideView(node));
	}
}