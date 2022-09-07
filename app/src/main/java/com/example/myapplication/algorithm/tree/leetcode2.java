package com.example.myapplication.algorithm.tree;

import com.example.myapplication.TreeNode;

public class leetcode2 {
    boolean Is = true;

    public boolean isValidBST(TreeNode root) {
        getNodeVal(root);
        return Is;
    }

    public void getNodeVal(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.val >= root.val) {
            Is = false;
            return;
        }

        if (root.right != null && root.right.val <= root.val) {
            Is = false;
            return;
        }
        getNodeVal(root.left);
        if(!Is){
            return;
        }
        getNodeVal(root.right);
    }
}
