package com.practice.ds.linkedlist;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        // If only head is present
        if (count == 1) {
            return null;
        }
        temp = head;
        count = count - n;
        //If node is head that needs to be removed
        if (count == 0) {
            return head.next;
        }

        //Traverse through the prev node that needs to removed
        while (count > 1) {
            temp = temp.next;
            count--;
        }
        temp.next = temp.next.next;
        return head;
    }
}
