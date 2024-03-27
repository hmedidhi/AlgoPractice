package com.practice.interview150.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNodeII {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            queue.add(null);
            while(size-->1){
                Node node = queue.remove();
                node.next= queue.peek();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            queue.remove();
        }
        return root;
    }
}

