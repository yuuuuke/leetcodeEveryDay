package com.example.myapplication;

import java.util.ArrayList;

public class leetcode116 {

    ArrayList<Node> arrayList = new ArrayList<>();

    public Node connect(Node root) {
        //后序遍历
        add(root, 0);
        return root;
    }

    private void add(Node node, int level) {
        if(node == null){
            return;
        }
        if (arrayList.size() < level + 1) {
            node.next = null;
            arrayList.add(level,node);
        } else {
            node.next = arrayList.get(level);
            arrayList.set(level, node);
        }
        add(node.right, level + 1);
        add(node.left, level + 1);
    }
}
