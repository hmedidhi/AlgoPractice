package com.practice.interview150.hard;

import com.practice.ds.linkedlist.ListNode;

public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            ListNode start = prev.next;
            ListNode end = cur;
            int count = 0;
            while (end != null && count == k) {
                end = end.next;
                count++;
            }
            if (count == k) {
                ListNode reverseSegmentStart = null;
                reverseSegmentStart = reverseList(start, k);

                prev.next = reverseSegmentStart;
                start.next = end;

                prev = start;
                cur = end;

            } else {
                break;
            }

        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode reverseNodeStart, int k) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = reverseNodeStart;
        while (cur != null && k > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        return prev;
    }
}
