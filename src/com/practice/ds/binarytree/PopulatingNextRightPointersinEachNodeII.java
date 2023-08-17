package com.practice.ds.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Node node = queue.remove();
                node.next = (size>0)?queue.element():null;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return root;
    }
}
