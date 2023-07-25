package com.practice.ds.linkedlist;

public class RemoveDuplicatesfromSortedListI {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            } else {
                cur = null;
            }
        }
        return head;
    }
}
