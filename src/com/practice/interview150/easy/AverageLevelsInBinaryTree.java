package com.practice.interview150.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new LinkedList<>();
        if (root == null)
            return result;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long size = queue.size();
            long totalelement = queue.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.remove(0);
                sum = sum + node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add((double) sum / totalelement);
        }
        return result;
    }
}
