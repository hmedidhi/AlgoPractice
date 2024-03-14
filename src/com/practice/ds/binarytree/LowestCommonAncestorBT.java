package com.practice.ds.binarytree;

import java.util.Stack;

public class LowestCommonAncestorBT {

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findElementDFS(root, p);
        return null;
    }

    private void findElementDFS(TreeNode root, TreeNode p) {

    }
}
