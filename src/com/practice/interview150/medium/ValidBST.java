package com.practice.interview150.medium;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        if (isValid(root.left, null, root.val) && isValid(root.right, root.val, null)) {
            return true;
        }
        return false;
    }

    private boolean isValid(TreeNode root, Integer leftMax, Integer rightMax) {
        if (root == null)
            return true;
        if ((leftMax != null && root.val <= leftMax) || (rightMax != null && root.val >= rightMax))
            return false;
        return isValid(root.left, leftMax, root.val) && isValid(root.right, root.val, rightMax);
    }
}
