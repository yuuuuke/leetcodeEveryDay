package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            } else {
                head = head.next;
            }
        }
        return null;
    }
}
