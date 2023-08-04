package com.example.myapplication.newstart.day2;

import android.util.Log;

import com.example.myapplication.ListNode;

public class q1 {

    public void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }
        // 找中点
        ListNode center = findCenter(head);
//        printNode(center);
        // 后半部分倒序
        center = reverseList(center);

        printNode(head);
        printNode(center);

        // 插入
        ListNode front = head;
        ListNode frontTemp = front.next;
        ListNode centerTemp = center.next;
        if (frontTemp == null) {
            head.next = center;
            return;
        }
        while (true) {
            front.next = center;
            center.next = frontTemp;
            center = centerTemp;
            if (centerTemp == null || frontTemp == null) {
                printNode(head);
                return;
            }
            centerTemp = centerTemp.next;
            front = frontTemp;
            frontTemp = frontTemp.next;
        }
    }

    private ListNode findCenter(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        if (low.next == null) {
            return low;
        } else {
            ListNode result = low.next;
            low.next = null;
            return result;
        }
    }

    private ListNode reverseList(ListNode node) {
        if (node.next == null) {
            return node;
        }
        if (node.next.next == null) {
            ListNode next = node.next;
            next.next = node;
            node.next = null;
            return next;
        }
        ListNode front = node;
        ListNode center = node.next;
        ListNode behind = node.next.next;
        front.next = null;

        while (true) {
            center.next = front;
            front = behind.next;
            behind.next = center;
            if (front == null) {
                System.out.println("////");
                return behind;
            }
            center = front.next;
            front.next = behind;
            if (center == null) {
                return front;
            }
            behind = center.next;
            if (behind == null) {
                center.next = front;
                return center;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);
//        ListNode node9 = new ListNode(10);
//        ListNode node10 = new ListNode(11);


        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;


        new q1().reorderList(node);
    }

    public void printNode(ListNode node){
        while (node!= null){
            System.out.print(node.val+"/");
            node = node.next;
        }
        System.out.println(" ");
    }
}
