package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

import java.util.HashSet;

public class leetcode3 {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head.next != null){
            if(!set.add(head.next)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
