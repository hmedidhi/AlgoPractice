package com.practice.ds.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            } else {
                if (list1.val < list2.val) {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                cur = cur.next;
            }
        }
        return result.next;
    }
}
