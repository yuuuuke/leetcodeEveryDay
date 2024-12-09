package com.example.myapplication.newstart.day12;

import com.example.myapplication.TreeNode;

import java.util.List;

public class q1 {

    private TreeNode head;

    public void flatten(TreeNode root) {
        xunhuan(root);
        root.right = null;
    }

    public void dropRight(TreeNode root) {

    }

    public void xunhuan(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left == null){
            head = node;
            System.out.println(head.val+"");
        }else{
            xunhuan(node.left);
        }

        if(node.right == null){
            head = node;
        }else{
            head.left = node;
            xunhuan(node.right);
        }
    }
}
