package com.practice.interview150.medium;

import java.util.LinkedList;
import java.util.List;

class BinaryTreeRightSideView {

    List<Integer> result = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        right(root, 0);
        return result;
    }

    private void right(TreeNode node, int depth) {
        if (node == null)
            return;
        if (depth == result.size())
            result.add(node.val);
        right(node.right, depth + 1);
        right(node.left, depth + 1);
    }
}