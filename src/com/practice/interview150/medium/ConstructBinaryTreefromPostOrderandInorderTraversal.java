package com.practice.interview150.medium;

import java.util.HashMap;

public class ConstructBinaryTreefromPostOrderandInorderTraversal {

    int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        TreeNode root = new TreeNode(postorder[index--]);
        int i = 0;
        while (root.val != inorder[i]) {
            i++;
        }
        root.right = buildTreeUtils(inorder, postorder, i + 1, inorder.length - 1);
        root.left = buildTreeUtils(inorder, postorder, 0, i - 1);
        return root;
    }

    private TreeNode buildTreeUtils(int[] inorder, int[] postorder, int start, int end) {
        if (end < start || end > inorder.length - 1)
            return null;
        TreeNode node = new TreeNode(postorder[index--]);
        int i = start;
        while (node.val != inorder[i])
            i++;
        node.right = buildTreeUtils(inorder, postorder, i + 1, end);
        node.left = buildTreeUtils(inorder, postorder, start, i - 1);
        return node;
    }
}
