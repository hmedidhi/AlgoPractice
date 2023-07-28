package com.practice.ds.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0 ){
            return head;
        }

        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        temp = head;
        int c = (k <= n) ? (n - k) : ((n - (k % n))%n);
        if(c==0)
            return head;

        while (c > 1) {
            temp = temp.next;
            c--;
        }
        ListNode nextHead = temp.next;
        temp.next = null;
        temp = nextHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = nextHead;
        return head;
    }
}
