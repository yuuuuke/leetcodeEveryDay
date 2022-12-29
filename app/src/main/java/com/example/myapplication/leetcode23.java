package com.example.myapplication;

public class leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //并归
        return merge(0, lists.length - 1, lists);
    }

    public ListNode merge(int start, int end, ListNode[] lists) {
        if (start == end) {
            return lists[start];
        } else if (end == start + 1) {
            return merge(lists[start], lists[end]);
        } else {
            return merge(merge(start, (end + start) / 2, lists), merge((end + start) / 2 + 1, end, lists));
        }
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null && node2 != null) {
            return node2;
        }
        if (node2 == null && node1 != null) {
            return node1;
        }
        if (node2 == null && node1 == null) {
            return null;
        }
        ListNode result;
        ListNode temp;
        if (node1.val < node2.val) {
            result = node1;
            node1 = node1.next;
        } else {
            result = node2;
            node2 = node2.next;
        }
        temp = result;
        while (true) {
            if (node1 == null) {
                result.next = node2;
                return temp;
            }
            if (node2 == null) {
                result.next = node1;
                return temp;
            }
            if (node1.val <= node2.val) {
                result.next = node1;
                result = result.next;
                node1 = node1.next;
            } else {
                result.next = node2;
                result = result.next;
                node2 = node2.next;
            }
        }
    }
}
