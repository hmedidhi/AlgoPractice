package com.practice.ds.linkedlist;

public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        while (cur != null) {
            ListNode start = cur;
            System.out.println("START : " + start.val);
            int count = k;
            while (cur != null && count > 0) {
                cur = cur.next;
                count--;
            }

            if (count == 0) {

            }


            ListNode end = cur;
            if (cur != null) {
                cur = cur.next;
            }
            ListNode node = reverseList(start, end);
            System.out.println(node.val);
            prev.next = node;
            while (node.next != null) {
                node = node.next;
            }
            prev = node;
            node.next = cur;

        }
        return dummyNode.next;
    }

    public ListNode reverseList(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode cur = start;
        if (end != null)
            end = end.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
