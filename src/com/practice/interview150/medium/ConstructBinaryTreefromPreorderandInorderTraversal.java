package com.practice.interview150.medium;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = new TreeNode(preorder[index++]);
        int i = 0;
        while (root.val != inorder[i]) {
            i++;
        }
        root.left = buildTreeUtils(inorder, preorder, 0, i - 1);
        root.right = buildTreeUtils(inorder, preorder, i + 1, inorder.length - 1);
        return root;
    }

    private TreeNode buildTreeUtils(int[] inorder, int[] preorder, int start, int end) {
        if (end < start || end > inorder.length - 1)
            return null;
        TreeNode node = new TreeNode(preorder[index++]);
        int i = start;
        while (node.val != inorder[i])
            i++;

        node.left = buildTreeUtils(inorder, preorder, start, i - 1);
        node.right = buildTreeUtils(inorder, preorder, i + 1, end);
        return node;
    }
}
