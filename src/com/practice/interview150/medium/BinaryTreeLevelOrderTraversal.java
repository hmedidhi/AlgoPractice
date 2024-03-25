package com.practice.interview150.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        levelOrderUtils(root, 0);
        return result;
    }

    private void levelOrderUtils(TreeNode node, int level) {
        if (node == null)
            return;
        if (level >= result.size()) {
            List<Integer> lst = new ArrayList<>();
            lst.add(node.val);
            result.add(lst);
        } else {
            result.get(level).add(node.val);
        }
        levelOrderUtils(node.left, level + 1);
        levelOrderUtils(node.right, level + 1);
    }
}
