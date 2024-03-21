package com.practice.interview150.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumAbsoluteDifferenceBST {

    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return min;
    }

    private void inOrderTraversal(TreeNode root) {
        if(root == null)
            return;
        inOrderTraversal(root.left);
        if(prev!=null)
            min = Math.min(min,root.val-prev.val);
        prev= root;
        inOrderTraversal(root.right);
    }
}
