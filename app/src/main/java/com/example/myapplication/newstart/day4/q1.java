package com.example.myapplication.newstart.day4;

import com.example.myapplication.ListNode;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/submissions/
 */
public class q1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode front = head.next;
        ListNode behind = head;

        head = front;

        ListNode temp = null;

        while (true) {
            if (front.next == null) {
                // 交换位置
                front.next = behind;
                behind.next = null;
                return head;
            }
            if (front.next.next == null) {
                behind.next = front.next;
                front.next = behind;
                return head;
            }
            temp = front.next;
            behind.next = front.next.next;
            front.next = behind;

            behind = temp;
            front = temp.next;
        }
    }
}
