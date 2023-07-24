package com.practice.ds.linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node dummyNode = new Node(-1);
        Node curHead = head;
        Node temp = dummyNode;
        HashMap<Node, Node> map = new HashMap<>();
        while (curHead != null) {
            temp.next = new Node(curHead.val);
            temp.next.random = curHead.random;
            temp = temp.next;
            map.put(curHead, temp);
            curHead = curHead.next;
        }
        temp = dummyNode.next;
        while (temp != null) {
            temp.random = map.get(temp.random);
            temp = temp.next;
        }
        return dummyNode.next;
    }
}


