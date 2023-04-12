package com.example.myapplication.algorithm.linkedList;

import com.example.myapplication.ListNode;

import java.util.List;

class MyLinkedList {

    private ListNode header;

    public MyLinkedList() {
        header = new ListNode(-1);
    }

    public int get(int index) {
        ListNode node = header;
        for (int i = 0; i <= index; i++) {
            if(node == null){
                return -1;
            }
            node = node.next;
        }
        if(node == null){
            return -1;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = header.next;
        header.next = node;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode index = header;
        while (index.next != null) {
            index = index.next;
        }
        index.next = node;
    }

    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        ListNode temp = header;
        for (int i = 0; i < index; i++) {
            if(temp == null){
                return;
            }
            temp = temp.next;
        }
        if(temp == null){
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void deleteAtIndex(int index) {
        ListNode temp = header;
        for (int i = 0; i < index; i++) {
            if(temp == null){
                return;
            }
            temp = temp.next;
        }
        if(temp == null || temp.next == null){
            return;
        }
        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
