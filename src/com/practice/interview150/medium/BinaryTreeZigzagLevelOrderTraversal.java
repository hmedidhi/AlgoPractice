package com.practice.interview150.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzagLevelOrderUtils(root, true, 0);
        return result;
    }

    private void zigzagLevelOrderUtils(TreeNode node, boolean zig, int level) {
        if(node==null)
            return;
        if(level>=result.size()){
            List<Integer> lst = new ArrayList<>();
            lst.add(node.val);
            result.add(lst);
        }
        result.get(level).add(node.val);
        if(zig){
            zigzagLevelOrderUtils(node.right,false,level+1);
            zigzagLevelOrderUtils(node.left,false,level+1);
        }else{
            zigzagLevelOrderUtils(node.left,false,level+1);
            zigzagLevelOrderUtils(node.right,false,level+1);
        }
    }
}
