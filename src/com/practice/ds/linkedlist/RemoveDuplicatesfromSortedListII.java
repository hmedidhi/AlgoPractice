package com.practice.ds.linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode temp = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            boolean check = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
                check = true;
            }
            if(!check){
                temp.next = new ListNode(cur.val,null);
                temp = temp.next;
            }
            cur = cur.next;
        }

        return dummyNode.next;
    }
}
