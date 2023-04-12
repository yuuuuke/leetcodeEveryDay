package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

public class leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head.next == null && head.val == val) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
