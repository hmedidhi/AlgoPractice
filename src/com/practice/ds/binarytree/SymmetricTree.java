package com.practice.ds.binarytree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return true;

        return isSymmetricUtils(root.left, root.right);
    }

    private boolean isSymmetricUtils(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left != null && right == null)
            return false;

        if (left == null && right != null)
            return false;

        if (left.val != right.val)
            return false;

        return isSymmetricUtils(left.left, right.right) && isSymmetricUtils(left.right, right.left);

    }
}
