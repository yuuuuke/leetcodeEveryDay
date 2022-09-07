package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

public class leetcode2 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode start = head;
        ListNode mid = head.next;
        if (mid == null) {
            return head;
        }
        ListNode end = mid.next;
        if (end == null) {
            mid.next = start;
            start.next = null;
            return mid;
        }

        start.next = null;
        mid.next = start;
        while (end.next != null) {
            start = mid;
            mid = end;
            end = end.next;
            mid.next = start;
        }
        end.next = mid;
        return end;
    }
}
