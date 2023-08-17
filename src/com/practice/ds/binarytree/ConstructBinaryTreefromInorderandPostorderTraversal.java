package com.practice.ds.binarytree;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    int index = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        index = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        int element = postorder[index--];

        int breakPoint = map.get(element);
        TreeNode root = new TreeNode(element);

        root.right = buildTreeUtils(breakPoint + 1, inorder.length - 1, postorder);
        root.left = buildTreeUtils(0, breakPoint - 1, postorder);


        return root;
    }

    private TreeNode buildTreeUtils(int i, int j, int[] postorder) {

        if (j < i)
            return null;

        int element = postorder[index--];
        int breakPoint = map.get(element);
        if (breakPoint == -1)
            return null;
        TreeNode root = new TreeNode(element);
        root.right = buildTreeUtils(breakPoint + 1, j, postorder);
        root.left = buildTreeUtils(i, breakPoint - 1, postorder);
        return root;
    }
}
