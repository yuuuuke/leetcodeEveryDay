package com.example.myapplication.algorithm.tree;

import com.example.myapplication.TreeNode;

public class leetcode1 {
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getNodeVal(root.left, 1);
        getNodeVal(root.right, 1);
        return max;
    }

    public void getNodeVal(TreeNode root, int layer) {
        if (root == null) {
            if (layer > max) {
                max = layer;
            }
            return;
        }
        layer++;
        getNodeVal(root.left, layer);
        getNodeVal(root.right, layer);
    }
}
