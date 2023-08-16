package com.practice.ds.binarytree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return root;
        dummy(root);
        return root;
    }

    private void dummy(TreeNode root){
        TreeNode temp = root.left;
        root.left=root.right;
        root.right= temp;
        if(root.left!=null)
            invertTree(root.left);
        if(root.right!=null)
            invertTree(root.right);
    }
}
