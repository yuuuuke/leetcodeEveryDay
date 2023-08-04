package com.example.myapplication.old;

import com.example.myapplication.ListNode;

public class leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode center = head;
        boolean tip = true;
        while (head.next != null) {
            head = head.next;
            if (!tip) {
                center = center.next;
                tip = true;
            } else {
                tip = false;
            }

            if(head.next == null && !tip){
                center = center.next;
            }
        }
        return center;
    }
}
