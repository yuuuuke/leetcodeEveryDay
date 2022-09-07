package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

public class leetcode1 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode start = head;
        for (int i = 0; i < n - 1; i++) {
            node = node.next;
        }
        while (true) {
            if (node.next == null) {
                ListNode next = start.next;
                if(next!=null){
                    start.val = next.val;
                    start.next = next.next;
                }else{
                    start = null;
                }
                return head;
            }
            node = node.next;
            start = start.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        System.out.println(removeNthFromEnd(head, 1).val);
    }
}
