package com.practice.interview150.medium;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeLinkedList {

    List<Integer> lst = new LinkedList<>();

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        while(root!=null && (root.left!=null||root.right!=null)) {
            if (root.left != null)
                preOrder(root.left);
            TreeNode temp = root.right;
            root.right= null;
            root.left=null;
            while (!lst.isEmpty()) {
                root.right = new TreeNode(lst.remove(0));
                root = root.right;
            }
            root.right = temp;
            root = root.right;
        }
    }

    private void preOrder(TreeNode root) {
        lst.add(root.val);
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }
}
