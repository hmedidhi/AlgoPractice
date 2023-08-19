package com.practice.ds.binarytree;

import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList {
    LinkedList<TreeNode> list = new LinkedList<>();

    public void flatten(TreeNode root) {
        preOrder(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            node.left = null;
            node.right = list.peek();
        }
    }

    public TreeNode preOrder(TreeNode node) {
        if (node != null) {
            list.add(node);
            preOrder(node.left);
            preOrder(node.right);
        }
        return node;
    }
}
