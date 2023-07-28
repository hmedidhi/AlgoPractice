package com.practice.ds.linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstPartHead = new ListNode(-1);
        ListNode firstHead = firstPartHead;
        ListNode secondPartHead = new ListNode(-1);
        ListNode secondHead = secondPartHead;
        while (head != null) {
            if (head.val < x) {
                firstHead.next = new ListNode(head.val);
                firstHead = firstHead.next;
            } else {
                secondHead.next = new ListNode(head.val);
                secondHead = secondHead.next;
            }
            head=head.next;
        }
        firstHead.next=secondPartHead.next;
        return firstPartHead.next;
    }
}
