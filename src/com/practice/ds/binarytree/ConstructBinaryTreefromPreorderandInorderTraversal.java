package com.practice.ds.binarytree;

import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    Stack<Integer> preStack = new Stack<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = preorder.length - 1; i >= 0; i--)
            preStack.push(preorder[i]);

        int element = preStack.pop();
        int breakPoint = findIndex(inorder, 0, inorder.length - 1, element);
        TreeNode root = new TreeNode(element);

        root.left = buildTreeUtils(inorder, 0, breakPoint - 1);
        root.right = buildTreeUtils(inorder, breakPoint + 1, inorder.length - 1);

        return root;
    }

    private TreeNode buildTreeUtils(int[] inorder, int i, int j) {
        if (j < i) {
            return null;
        }
        //System.out.println("i = "+i+" j = "+ j+ " stack peek = "+ preStack.peek());
        int element = preStack.pop();
        int breakPoint = findIndex(inorder, i, j, element);
        if (breakPoint == -1)
            return null;
        TreeNode root = new TreeNode(element);
        root.left = buildTreeUtils(inorder, i, breakPoint - 1);
        root.right = buildTreeUtils(inorder, breakPoint + 1, j);
        return root;
    }

    private int findIndex(int[] inorder, int i, int j, int element) {
        for (int k = i; k <= j; k++) {
            if (element == inorder[k])
                return k;
        }
        return -1;
    }
}
