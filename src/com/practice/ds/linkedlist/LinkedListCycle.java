package com.practice.ds.linkedlist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode node1 = head;
        if (node1 != null) {
            ListNode node2 = head.next;
            while (node2 != null && node2.next != null) {
                if (node1.val == node2.val)
                    return true;
                node1 = node1.next;
                node2 = node2.next.next;
            }
        }
        return false;
    }
}
