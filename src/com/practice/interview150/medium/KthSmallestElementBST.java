package com.practice.interview150.medium;

import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementBST {

    List<Integer> result = new LinkedList<>();
    int val=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return val;
    }

    private void inOrder(TreeNode root, int k) {
        if(root==null||result.size()>=k)
            return;
        if(root.left!=null)
            inOrder(root.left,k);
        result.add(root.val);
        if(result.size()==k)
            val=root.val;
        if(root.right!=null)
            inOrder(root.right,k);
    }
}
