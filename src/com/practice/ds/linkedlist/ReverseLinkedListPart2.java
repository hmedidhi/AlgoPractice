package com.practice.ds.linkedlist;

public class ReverseLinkedListPart2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prevHead = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prevHead = prevHead.next;
        }
        ListNode cur = prevHead.next;
        ListNode prev = null;
        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        prevHead.next = prev;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = cur;
        return dummyHead.next;
    }
}
