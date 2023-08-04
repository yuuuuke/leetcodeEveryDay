package com.example.myapplication.old;

import com.example.myapplication.ListNode;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val > list2.val) {
            head = list2;
            if(list2.next == null){
                head.next = list1;
                return head;
            }else{
                list2 = list2.next;
            }
        } else {
            head = list1;
            if(list1.next == null){
                head.next = list2;
                return head;
            }else{
                list1 = list1.next;
            }
        }
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                temp = temp.next;
                if(list2.next == null){
                    temp.next = list1;
                    return head;
                }else{
                    list2 = list2.next;
                }
            } else {
                temp.next = list1;
                temp = temp.next;
                if(list1.next == null){
                    temp.next = list2;
                    return head;
                }else{
                    list1 = list1.next;
                }
            }
        }
        return head;
    }
}
