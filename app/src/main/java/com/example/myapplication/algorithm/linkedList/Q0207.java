package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

public class Q0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLinkLength(headA);
        int bLength = getLinkLength(headB);
        if (aLength > bLength) {
            int index = aLength - bLength;
            while (index > 0) {
                headA = headA.next;
                index--;
            }
        } else {
            int index = bLength - aLength;
            while (index > 0) {
                headB = headB.next;
                index--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null) {
                return null;
            }
        }
        return headA;
    }

    public int getLinkLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
