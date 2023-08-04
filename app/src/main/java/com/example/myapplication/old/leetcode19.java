package com.example.myapplication.old;

import com.example.myapplication.ListNode;

import java.util.ArrayList;

public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode node = head;
        while (node.next != null) {
            list.add(node);
            node = node.next;
        }
        if(n == 1){
            //去掉最后一位
            list.get(list.size() - 2).next = null;
        }else if(n == list.size()){
            //去掉第一位
            return list.get(1);
        }else{
            int index = list.size() - n;
            list.get(index - 1).next = list.get(index + 1);
        }
        return head;
    }
}